package com.lh.googleioschedule.session

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SessionDetailScreen(sessionUiModel: SessionUiModel) {
    Column(modifier = Modifier.padding(4.dp)) {
        Text(
            sessionUiModel.name,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(sessionUiModel.time)
        Spacer(modifier = Modifier.height(4.dp))
        Text(sessionUiModel.location)
        Spacer(modifier = Modifier.height(12.dp))

        Text(sessionUiModel.description)
    }
}

@Preview
@Composable
fun SessionDetailScreenPreview() {
    val sessionUiModel = SessionUiModel(
        "Accessibility App reviews",
        "When you improve your app's accessibility, you improve your product for everyone, including the billion people worldwide who live with a disability. Sign up for Accessibility App Reviews if you are working on an Android app and want to learn how to make it more accessible with experts from the Android team. We will walk you through UX and development best practices, how to test your app to find opportunities for improvements and how to implement improvements. Walk-ins are welcome.",
        "Some time",
        "Room A",
        "App Reviews"
    )
    SessionDetailScreen(sessionUiModel)
}