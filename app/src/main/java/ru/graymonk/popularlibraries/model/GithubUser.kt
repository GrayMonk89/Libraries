package ru.graymonk.popularlibraries.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUser(
    val id: Long,
    val login: String,
    val avatar_url: String
): Parcelable