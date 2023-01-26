package ru.graymonk.popularlibraries.repository.implementation

import io.reactivex.rxjava3.core.Single
import ru.graymonk.popularlibraries.core.database.UserDAO
import ru.graymonk.popularlibraries.core.mapper.RepositoryMapper
import ru.graymonk.popularlibraries.core.mapper.UserMapper
import ru.graymonk.popularlibraries.core.network.UsersApi
import ru.graymonk.popularlibraries.core.utils.doCompletableIf
import ru.graymonk.popularlibraries.model.GithubRepository
import ru.graymonk.popularlibraries.model.GithubUser
import ru.graymonk.popularlibraries.repository.IGithubRepository

class GithubRepositoryImpl constructor(
    private val usersApi: UsersApi,
    private val userDAO: UserDAO,
    private val networkStatus: Single<Boolean>
) : IGithubRepository {
    override fun getUsers(): Single<List<GithubUser>> {
        //return fetchFromApi(true)
        return networkStatus.flatMap { hasConnection ->
            if (hasConnection) {
                fetchFromApi(true)
            } else {
                getFromDataBase()
            }
        }
    }

    private fun fetchFromApi(shouldPersist: Boolean): Single<List<GithubUser>> {
        return usersApi.getAllUsers()
            .doCompletableIf(shouldPersist) {
                userDAO.insertAll(it.map(UserMapper::mapToDataBaseObject))
            }
            .map { it.map(UserMapper::mapToEntity) }
    }

    private fun getFromDataBase(): Single<List<GithubUser>> {
        return userDAO.queryForAllUsers().map { it.map(UserMapper::mapToEntity) }
    }

    override fun getUserWithRepositories(login: String): Single<GithubUser>{
        return userDAO.getUserWithRepository(login).map {userWithRepositories ->
            val user = UserMapper.mapToEntity(userWithRepositories.userDataBaseObject)
            user.repositories = userWithRepositories.repositories.map { RepositoryMapper.map(it) }
            user
        }
    }

    override fun getUserByLogin(login: String): Single<GithubUser> {
        return usersApi.getUser(login).map(UserMapper::mapToEntity)
    }

    override fun getReposByLogin(login: String): Single<List<GithubRepository>> {
        return usersApi.getRepos(login)
            .map { it.map(RepositoryMapper::map) }
    }
}