package com.kei.githubfirstsubmission.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Users(
    val follower: Int,
    val following: Int,
    val name: String,
    val company: String,
    val location: String,
    val avatar: String,
    val repository: Int,
    val username: String
):Parcelable
