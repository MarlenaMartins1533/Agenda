package com.marlena.agenda.core

import android.app.Application
import com.marlena.agenda.persistence.AgendaDB

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        AgendaDB.initialize(this)

    }
}