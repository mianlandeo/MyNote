package com.example.mynotes.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(@PrimaryKey(autoGenerate = true) val id: Int,
                @ColumnInfo(name = "firstName") val firstName: String,
                @ColumnInfo(name = "lastName") val lastName: String,
                @ColumnInfo(name = "age") val age: Int
)