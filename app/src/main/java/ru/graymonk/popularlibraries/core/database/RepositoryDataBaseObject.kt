package ru.graymonk.popularlibraries.core.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "repository"
)//Constants.DataBase.CONST_REPOSITORY_TABLE_NAME
data class RepositoryDataBaseObject(
    @PrimaryKey
    @ColumnInfo(name = PRIMARY_KEY)
    val id: Long,
    val forks: Int,
    val name: String,
    @ColumnInfo(name = FOREIGN_USER_KEY)
    val userId: Long
) {
    companion object{
        const val PRIMARY_KEY = "id"
        const val FOREIGN_USER_KEY = "userId"
    }
}
