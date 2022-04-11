package com.lh.googleioschedule.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SocialLinks (
    @SerialName("GitHub") val github: String,
    @SerialName("Website") val website:  String,
    @SerialName("Twitter")val twitter: String,
    @SerialName("LinkedIn")val linkedIn: String
)