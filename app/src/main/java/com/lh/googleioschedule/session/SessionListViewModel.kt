package com.lh.googleioschedule.session

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SessionListViewModel : ViewModel() {

    private val mutableSessions = MutableLiveData<List<SessionUiModel>>()
    val sessionsLiveData: LiveData<List<SessionUiModel>> = mutableSessions

    var uiState by mutableStateOf(SessionListState(emptyList()))
        private set

    fun loadSessionState() {
        //todo load sessions from viewmodel
        uiState = SessionListState(
            mutableListOf(
                SessionUiModel("A", "A Description", "A Time", "A Place", ""),
                SessionUiModel("B", "B Description", "B Time", "B Place", ""),
                SessionUiModel("C", "C Description", "C Time", "C Place", ""),
                SessionUiModel("D", "D Description", "D Time", "D Place", ""),
                SessionUiModel("E", "E Description", "E Time", "E Place", ""),
                SessionUiModel("F", "F Description", "F Time", "F Place", ""),
                SessionUiModel("G", "G Description", "G Time", "G Place", ""),
                SessionUiModel("H", "H Description", "H Time", "H Place", ""),
                SessionUiModel("I", "I Description", "I Time", "I Place", ""),
                SessionUiModel("J", "J Description", "J Time", "J Place", ""),
                SessionUiModel("K", "K Description", "K Time", "K Place", ""),
                SessionUiModel("L", "L Description", "L Time", "L Place", ""),
                SessionUiModel("M", "M Description", "M Time", "M Place", ""),
                SessionUiModel("N", "N Description", "N Time", "N Place", ""),
            )
        )
    }

}