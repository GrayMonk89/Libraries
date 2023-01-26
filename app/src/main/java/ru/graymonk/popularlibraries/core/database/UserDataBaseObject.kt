package ru.graymonk.popularlibraries.core.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")//Constants.DataBase.CONST_USERS_TABLE_NAME
data class UserDataBaseObject(
    @PrimaryKey
    @ColumnInfo(name = PRIMARY_KEY)
    val id: Long,
    val login: String,
    val avatarUrl: String,
) {
    companion object{
        const val PRIMARY_KEY = "id"
    }
}