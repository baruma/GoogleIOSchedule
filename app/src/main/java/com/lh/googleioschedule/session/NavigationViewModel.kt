package com.lh.googleioschedule.session

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.lh.googleioschedule.ScreenConfig

class NavigationViewModel(initialConfig: ScreenConfig) :
    ViewModel() {

    var state by mutableStateOf(NavigationState(initialConfig.name, initialConfig.canNavigateUp))
        private set

    fun updateNavigationState(screenConfig: ScreenConfig) {
        state = NavigationState(screenConfig.name, screenConfig.canNavigateUp)
    }
}

data class NavigationState(val title: String, val canNavigateUp: Boolean)