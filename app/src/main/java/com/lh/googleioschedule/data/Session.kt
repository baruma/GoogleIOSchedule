package com.lh.googleioschedule.data

class Session {
    val id = String
    val code = String
    val title = String
    val description = String
    val type = String
    val contentLevels = arrayListOf<String>()
    val tagNames = arrayListOf<String>()
    val startTime = Int
    val endTime = Int
    val liveStream = Boolean
    val youtubeUrl = String
    val youtubeVideoType = String
    val isFeatured = Boolean
    val room = String
    val speakers = arrayListOf<String>()
    val relatedSessions = arrayListOf<String>()
    val doryLink = String
    val section = Int
}