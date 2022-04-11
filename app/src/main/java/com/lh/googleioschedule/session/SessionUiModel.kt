package com.lh.googleioschedule.session

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SessionUiModel(
    val name: String,
    val description: String,
    val time: String,
    val location: String,
    val tags: String
) : Parcelable