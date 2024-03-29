package ru.graymonk.popularlibraries.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUser(
    val id: Long,
    val login: String,
    val avatarUrl: String,
    var repositories: List<GithubRepository>? = null
): Parcelable