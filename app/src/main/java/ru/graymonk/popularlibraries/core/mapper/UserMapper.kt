package ru.graymonk.popularlibraries.core.mapper

import ru.graymonk.popularlibraries.core.database.UserDataBaseObject
import ru.graymonk.popularlibraries.model.GithubUser
import ru.graymonk.popularlibraries.core.network.UserDto

object UserMapper {
    fun mapToEntity(userDto: UserDto): GithubUser {
        return GithubUser(
            id = userDto.id,
            login = userDto.login,
            avatarUrl = userDto.avatarUrl
        )
    }

    fun mapToEntity(dataBaseObject: UserDataBaseObject): GithubUser {
        return GithubUser(
            id = dataBaseObject.id,
            login = dataBaseObject.login,
            avatarUrl = dataBaseObject.avatarUrl
        )
    }

    fun mapToDataBaseObject(userDto: UserDto): UserDataBaseObject {
        return UserDataBaseObject(
            id = userDto.id,
            login = userDto.login,
            avatarUrl = userDto.avatarUrl
        )
    }
}