package com.example.mynotes

import android.app.Application
import com.example.mynotes.model.DataBaseUser

class AppMain: Application() {

        val database : DataBaseUser by lazy { DataBaseUser.getDatabase(this) }


}