package ru.graymonk.popularlibraries.repository.implementation

import io.reactivex.rxjava3.core.Single
import ru.graymonk.popularlibraries.model.GithubUser
import ru.graymonk.popularlibraries.repository.GithubRepository
import java.util.concurrent.TimeUnit

class GithubRepositoryImpl : GithubRepository {
    private val repository =
        listOf(
            GithubUser("John"),
            GithubUser("Sara"),
            GithubUser("Hudson"),
            GithubUser("Aang"),
            GithubUser("Kung Fury"),
            GithubUser("Ellen Ripley"),
            GithubUser("Sarah Conor"),
            GithubUser("Dwayne Hicks"),
            GithubUser("John McClane"),
            GithubUser("Alan Schaefer"),
            GithubUser("Tyler Durden"))


    override fun getUsers(): Single<List<GithubUser>> {
        return Single.just(repository).delay(5L, TimeUnit.SECONDS)
//        return Single.create {
//            it.onSuccess(repository)
//        }
    }
}