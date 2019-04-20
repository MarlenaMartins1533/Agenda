package com.marlena.agenda.service

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.marlena.agenda.model.Contact

class WeatherService {

    companion object { //singleton - only one instance
        lateinit var instance: WeatherService
            private set

        fun initialize(applicationContext: Context) {
            instance = Room.databaseBuilder(applicationContext, WeatherService::class.java, "agenda.db").apply {
                allowMainThreadQueries()
            }.build()
        }
    }

    abstract fun contactDAO(): ContactDAO
}