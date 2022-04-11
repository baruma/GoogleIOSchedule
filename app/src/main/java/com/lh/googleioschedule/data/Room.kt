package com.lh.googleioschedule.data

import kotlinx.serialization.Serializable

@Serializable
data class Room  (
    val id: String,
    val capacity: String,
    val name: String,
    val filter: Boolean
    )