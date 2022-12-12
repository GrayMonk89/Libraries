package ru.graymonk.popularlibraries.user.detail

import ru.graymonk.popularlibraries.model.GithubUser

interface OnItemClickListener {
    fun onItemClick(gitHubUser: GithubUser)
}