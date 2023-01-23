package ru.graymonk.popularlibraries.core.mapper

import ru.graymonk.popularlibraries.model.GithubRepository
import ru.graymonk.popularlibraries.core.network.RepositoryDto

object RepositoryMapper {
    fun map(repositoryDto: RepositoryDto): GithubRepository {
        return GithubRepository(
            id = repositoryDto.id,
            forks = repositoryDto.forks,
            name = repositoryDto.name
        )
    }
}