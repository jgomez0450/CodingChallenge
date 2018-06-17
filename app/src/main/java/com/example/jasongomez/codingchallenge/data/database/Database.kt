package com.example.jasongomez.codingchallenge.data.database

import android.arch.persistence.room.RoomDatabase
import com.example.jasongomez.codingchallenge.data.database.dao.NetworkDao

abstract class Database : RoomDatabase() {
    abstract fun networkDao(): NetworkDao
}