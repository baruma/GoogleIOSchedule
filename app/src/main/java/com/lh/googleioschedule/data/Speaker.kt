package com.lh.googleioschedule.data

import kotlinx.serialization.Serializable

@Serializable
data class Speaker (
    val id:  String,
    val name: String,
    val bio: String,
    val company: String,
    val thumbnailUrl: String,
    val socialLinks: SocialLinks
)