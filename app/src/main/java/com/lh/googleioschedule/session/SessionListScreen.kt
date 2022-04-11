package com.lh.googleioschedule.session

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun SessionTimeline(
    sessionListViewModel: SessionListViewModel,
    onItemClicked: (SessionUiModel) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(top = 8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        val sessions = sessionListViewModel.uiState.sessions
        items(sessions.size) { index ->
            SessionRow(
                session = sessions[index],
                onItemClicked = {
                    onItemClicked(it)
                }
            )
        }
    }
}

@Composable
fun SessionRow(session: SessionUiModel, onItemClicked: (SessionUiModel) -> Unit) {
    Column(
        modifier = Modifier
            .padding(4.dp)
            .clickable { onItemClicked(session) }
    ) {
        Text(session.name)
        Spacer(modifier = Modifier.height(4.dp))
        Text(session.time)
        Spacer(modifier = Modifier.height(4.dp))
        Text(session.location)
    }
}
