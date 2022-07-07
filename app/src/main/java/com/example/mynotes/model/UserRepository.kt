package com.example.mynotes.model

import androidx.lifecycle.LiveData
import com.example.mynotes.model.dao.UserDao
import com.example.mynotes.model.entity.User


class UserRepository(private val userDao: UserDao) {

    val getAlphabetizedUser : LiveData<List<User>> = userDao.getAlphabetizedUser()

    @Suppress()
    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

    suspend fun upData(user: User){
        userDao.upUserData(user)
    }

    suspend fun delete(user: User){
        userDao.delete(user)
    }

}