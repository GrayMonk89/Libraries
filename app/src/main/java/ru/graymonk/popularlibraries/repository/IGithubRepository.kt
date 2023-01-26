package ru.graymonk.popularlibraries.repository

import io.reactivex.rxjava3.core.Single
import ru.graymonk.popularlibraries.model.GithubRepository
import ru.graymonk.popularlibraries.model.GithubUser

interface IGithubRepository {
    fun getUsers(): Single<List<GithubUser>>

    fun getUserByLogin(login: String): Single<GithubUser>

    fun getReposByLogin(login: String): Single<List<GithubRepository>>
    fun getUserWithRepositories(login: String): Single<GithubUser>
}