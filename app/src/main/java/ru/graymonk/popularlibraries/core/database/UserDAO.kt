package ru.graymonk.popularlibraries.core.database

import androidx.room.*
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
abstract class UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(userDataBaseObject: UserDataBaseObject): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAll(userDataBaseObject: List<UserDataBaseObject>): Completable

    @Query("SELECT * FROM users")
    abstract fun queryForAllUsers(): Single<List<UserDataBaseObject>>

    @Delete
    abstract fun delete(userDataBaseObject: UserDataBaseObject): Completable

    @Transaction
    @Query("SELECT * FROM users WHERE login = :login")
    abstract fun getUserWithRepository(login: String): Single<UserWithRepositoryDataBaseObject>
}