package ru.graymonk.popularlibraries.core.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [UserDataBaseObject::class,RepositoryDataBaseObject::class],
    version = 1
)
abstract class GithubAppDataBase : RoomDatabase() {
    abstract fun userDao(): UserDAO

    companion object {
        fun create(context: Context): GithubAppDataBase {
            return Room.databaseBuilder(
                context,
                GithubAppDataBase::class.java,
                "github.db"
            ).build()
        }
    }
}