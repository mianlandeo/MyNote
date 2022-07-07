package com.example.mynotes.model.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mynotes.model.entity.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC ")
    fun getAlphabetizedUser(): LiveData<List<User>>

    @Update
    fun upUserData(user: User)

    @Delete
    fun delete(user: User)


}