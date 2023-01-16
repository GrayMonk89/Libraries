package ru.graymonk.popularlibraries.core.mapper

import ru.graymonk.popularlibraries.model.GithubUser
import ru.graymonk.popularlibraries.network.UserDto

object UserMapper {
    fun mapToEntity(userDto: UserDto):GithubUser {
        return GithubUser(id = userDto.id, login = userDto.login, avatarUrl = userDto.avatarUrl)
    }
}