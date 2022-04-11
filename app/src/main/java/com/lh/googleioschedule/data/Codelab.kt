package com.lh.googleioschedule.data

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class Codelab(
    val id: String,
    val priority: Int,
    val title: String,
    val description: String,
    val duration: String,
    val icon: String,
    val link: String,
    val tagNames: List<String> = emptyList()
    )
