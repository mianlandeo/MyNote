package com.example.mynotes.view

import android.app.Application
import android.text.Editable
import android.text.TextUtils
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.mynotes.model.DataBaseUser
import com.example.mynotes.model.UserRepository
import com.example.mynotes.model.entity.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UserViewModel(application: Application): AndroidViewModel(application) {

    private val readAllData : LiveData<List<User>>
    private val repository : UserRepository

    init {
        val userDao = DataBaseUser.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.getAlphabetizedUser
    }

    private fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

    fun upDateBase(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.upData(user)
        }
    }

    fun delete(user : User){
        viewModelScope.launch(Dispatchers.IO){
            repository.delete(user)
        }
    }

    fun addNewUser(firstName: String, lastName: String, age: String){
        val user = User(0, firstName, lastName, age.toInt())
        addUser(user)
    }

    fun isEntryValid(firstName: String, lastName: String, age: String): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }

}