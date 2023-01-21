package ru.graymonk.popularlibraries.user

import ru.graymonk.popularlibraries.model.GithubUser

interface OnItemClickListener {
    fun onItemClick(gitHubUser: GithubUser)
}