package com.lh.googleioschedule.data

import kotlinx.serialization.Serializable

@Serializable
data class ConferencePayload (
    val codelabs: List<Codelab>,
    val sessions: List<Session> = emptyList(),
    val tags: List<Tag> = emptyList(),
    val rooms: List<Room> = emptyList(),
    val speakers: Map<String, Speaker> = emptyMap()
)