package ru.graymonk.popularlibraries.repository

import ru.graymonk.popularlibraries.model.GithubUser

interface GithubRepository {
    fun getUsers():List<GithubUser>
}