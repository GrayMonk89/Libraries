package ru.graymonk.popularlibraries.repository.implementation

import ru.graymonk.popularlibraries.model.GithubUser
import ru.graymonk.popularlibraries.repository.GithubRepository

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


    override fun getUsers(): List<GithubUser>{
        return repository
    }
}