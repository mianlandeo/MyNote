package com.example.mynotes.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mynotes.model.dao.UserDao
import com.example.mynotes.model.entity.User


@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class DataBaseUser: RoomDatabase() {

        abstract fun userDao(): UserDao

        companion object{
                @Volatile
                private var INSTANCE : DataBaseUser? = null

                fun getDatabase(context: Context): DataBaseUser{

                        return INSTANCE ?: synchronized(this){
                                val instance = Room.databaseBuilder(
                                        context.applicationContext,
                                        DataBaseUser::class.java,
                                        "user_table")
                                        .fallbackToDestructiveMigration()
                                        .build()
                                INSTANCE = instance
                                instance
                        }
                }
        }
}