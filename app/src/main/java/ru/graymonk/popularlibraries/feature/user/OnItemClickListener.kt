package ru.graymonk.popularlibraries.feature.user

import ru.graymonk.popularlibraries.model.GithubUser

interface OnItemClickListener {
    fun onItemClick(gitHubUser: GithubUser)
}