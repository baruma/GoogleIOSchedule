package com.lh.googleioschedule.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Tag (
    val id: String,
    val name: String,
    @SerialName("order_in_category") val orderInCategory: Int,
    val category: String,
    val tag: String,
    val color: String = "",
    val fontColor: String = ""
)