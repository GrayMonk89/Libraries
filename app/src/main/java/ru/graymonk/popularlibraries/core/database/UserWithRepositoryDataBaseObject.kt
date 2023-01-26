package ru.graymonk.popularlibraries.core.database

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithRepositoryDataBaseObject(
    @Embedded
    val userDataBaseObject: UserDataBaseObject,
    @Relation(
        parentColumn = UserDataBaseObject.PRIMARY_KEY,
        entityColumn = RepositoryDataBaseObject.FOREIGN_USER_KEY
    )
    val repositories: List<RepositoryDataBaseObject>
    )
