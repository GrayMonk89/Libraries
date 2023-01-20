package ru.graymonk.popularlibraries.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubRepository(
    val id: Long,
    val forks: Int,
    val name: String
) : Parcelable
