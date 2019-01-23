package com.marlena.agenda.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.marlena.agenda.model.Contact

@Database(entities = [Contact::class], version = 1)
abstract class AgendaDB : RoomDatabase() {

    companion object {
        lateinit var instance: AgendaDB
            private set

        fun initialize(applicationContext: Context) {
            instance = Room.databaseBuilder(applicationContext, AgendaDB::class.java, "agenda.db").apply {
                allowMainThreadQueries()
            }.build()
        }
    }

    abstract fun contactDAO(): ContactDAO
}