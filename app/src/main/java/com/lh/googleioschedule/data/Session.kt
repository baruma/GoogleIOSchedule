package com.lh.googleioschedule.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Session (
    val id: String,
    val code: String,
    val title: String,
    val description: String,
    val type: String,
    val contentLevels: List<String> = emptyList(),
    val tagNames: List<String> = emptyList(),
    @SerialName("startTimestamp") val startTime: Long,
    @SerialName("endTimestamp") val endTime: Long,
    val livestream: Boolean,
    val youtubeUrl: String,
    val youtubeVideoType: String,
    val isFeatured: Boolean,
    val room: String,
    val speakers: List<String> = emptyList(),
    val relatedSessions: List<String> = emptyList(),
    val doryLink: String,
    val section: String
)