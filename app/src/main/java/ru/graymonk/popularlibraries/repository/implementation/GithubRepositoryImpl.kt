package ru.graymonk.popularlibraries.repository.implementation

import io.reactivex.rxjava3.core.Single
import ru.graymonk.popularlibraries.core.mapper.RepositoryMapper
import ru.graymonk.popularlibraries.core.mapper.UserMapper
import ru.graymonk.popularlibraries.model.GithubRepository
import ru.graymonk.popularlibraries.model.GithubUser
import ru.graymonk.popularlibraries.network.UsersApi
import ru.graymonk.popularlibraries.repository.IGithubRepository

class GithubRepositoryImpl constructor(
    private val usersApi: UsersApi
) : IGithubRepository {
    override fun getUsers(): Single<List<GithubUser>> {
        return usersApi.getAllUsers()
            .map { it.map(UserMapper::mapToEntity) }
    }

    override fun getUserByLogin(login: String): Single<GithubUser> {
        return usersApi.getUser(login).map(UserMapper::mapToEntity)
    }

    override fun getReposByLogin(login: String): Single<List<GithubRepository>> {
        return usersApi.getRepos(login)
            .map { it.map(RepositoryMapper::map) }
    }
}