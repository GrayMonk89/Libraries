package ru.graymonk.popularlibraries.repository

import io.reactivex.rxjava3.core.Single
import ru.graymonk.popularlibraries.model.GithubUser

interface GithubRepository {
    fun getUsers(): Single<List<GithubUser>>
}