package ru.graymonk.popularlibraries.repository.implementation

import io.reactivex.rxjava3.core.Single
import ru.graymonk.popularlibraries.model.GithubUser
import ru.graymonk.popularlibraries.repository.GithubRepository
import java.util.concurrent.TimeUnit

class GithubRepositoryImpl : GithubRepository {
    private val repository =
        listOf(
            GithubUser(1,"John",""),
            GithubUser(2,"Sara",""),
            GithubUser(3,"Hudson",""),
            GithubUser(4,"Aang",""),
            GithubUser(5,"Kung Fury",""),
            GithubUser(6,"Ellen Ripley",""),
            GithubUser(7,"Sarah Conor",""),
            GithubUser(8,"Dwayne Hicks",""),
            GithubUser(9,"John McClane",""),
            GithubUser(10,"Alan Schaefer",""),
            GithubUser(11,"Tyler Durden",""))


    override fun getUsers(): Single<List<GithubUser>> {
        return Single.just(repository).delay(5L, TimeUnit.SECONDS)
//        return Single.create {
//            it.onSuccess(repository)
//        }
    }
}