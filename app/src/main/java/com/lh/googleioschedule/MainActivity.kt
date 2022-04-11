package com.lh.googleioschedule

import android.net.Uri
import android.os.Bundle
import android.telecom.Conference
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lh.googleioschedule.data.ConferencePayload
import com.lh.googleioschedule.session.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import java.io.File

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavController

    private val sessionListViewModel: SessionListViewModel by viewModels()

    private val navigationViewModel: NavigationViewModel by lazy {
        ViewModelProvider(
            this,
            NavigationViewModelFactory(SessionListScreenConfig)
        )[NavigationViewModel::class.java]
    }

    class NavigationViewModelFactory(val initialConfig: ScreenConfig) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(ScreenConfig::class.java).newInstance(initialConfig)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

/*
    If you think your JSON Serializing is correct - think again and check it 3x.

    Remember to half the scope so you can pin point where errors are stemming from.

    Remember to create default values if you need to speed through testing to find errors.
 */
        val uri = Uri.parse("android.resource://com.lh.googleioschedule/raw/conference_data.json")
        val file = File(uri.path)

        // It is more reliable to access resources from raw resources instead of strings.  The uri
        // and file didn't work because it was empty.
        val inputStream = resources.openRawResource(R.raw.conference_data)
        val json = Json { ignoreUnknownKeys = true }
        val obj = json.decodeFromStream<ConferencePayload>(inputStream)
        print(obj)

        setContent {
            navController = rememberNavController()
            CustomScaffold(
                title = navigationViewModel.state.title,
                upAvailable = navigationViewModel.state.canNavigateUp,
                onUpClicked = { navController.navigateUp() },
                content = { Content() }
            )
        }

        sessionListViewModel.loadSessionState()
    }

    @Composable
    fun Content() {
        Column {
            NavHost(
                navController = navController as NavHostController,
                startDestination = SessionListScreenConfig.name
            ) {
                composable(SessionListScreenConfig.name) {
                    navigationViewModel.updateNavigationState(SessionListScreenConfig)
                    SessionTimeline(sessionListViewModel) {
                        navController.navigate(
                            SessionDetailScreenConfig.name,
                            Pair("Session", it)
                        )
                    }
                }
                composable(SessionDetailScreenConfig.name) { entry ->
                    navigationViewModel.updateNavigationState(SessionDetailScreenConfig)
                    val session = entry.requiredArg<SessionUiModel>("Session")
                    SessionDetailScreen(session)
                }
            }
        }
    }

    @Composable
    fun CustomScaffold(
        title: String,
        upAvailable: Boolean,
        onUpClicked: () -> Unit,
        content: @Composable (PaddingValues) -> Unit
    ) {
        Scaffold(
            topBar = {
                if (upAvailable) {
                    TopAppBar(title = { Text(text = title) }, navigationIcon = {
                        if (upAvailable) {
                            IconButton(onClick = { onUpClicked() }) {
                                Icon(
                                    imageVector = Icons.Filled.ArrowBack,
                                    contentDescription = "Back",
                                    tint = Color.White
                                )
                            }
                        }
                    })
                } else {
                    TopAppBar(title = { Text(text = title) })
                }
            },
            content = content
        )
    }
}
