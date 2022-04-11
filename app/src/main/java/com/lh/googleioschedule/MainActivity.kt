package com.lh.googleioschedule

import android.net.Uri
import android.os.Bundle
import android.telecom.Conference
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.lh.googleioschedule.data.Codelab
import com.lh.googleioschedule.data.ConferencePayload
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import java.io.File

class MainActivity : ComponentActivity() {

    val uri = Uri.parse("android.resource://com.lh.googleioschedule/raw/conference_data.json")
    val file = File(uri.path)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard("Hello world")
        }

        // It is more reliable to access resources from raw resources instead of strings.  The uri
        // and file didn't work because it was empty.
        val inputStream = resources.openRawResource(R.raw.conference_data)
        val json = Json { ignoreUnknownKeys = true }
        val obj = json.decodeFromStream<ConferencePayload>(inputStream)
        print(obj)
    }

    @Composable
    fun MessageCard(name: String) {
        Text(text = "Hello $name!")
    }

    @Preview
    @Composable
    fun PreviewMessageCard() {
        MessageCard("Android")
    }

}

/*
    If you think your JSON Serializing is correct - think again and check it 3x.

    Remember to half the scope so you can pin point where errors are stemming from.

    Remember to create default values if you need to speed through testing to find errors.
 */