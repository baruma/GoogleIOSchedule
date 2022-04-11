package com.lh.googleioschedule

sealed class ScreenConfig(val name: String, val canNavigateUp: Boolean)

object SessionListScreenConfig: ScreenConfig("SessionList", false)

object SessionDetailScreenConfig: ScreenConfig("SessionDetail",true)