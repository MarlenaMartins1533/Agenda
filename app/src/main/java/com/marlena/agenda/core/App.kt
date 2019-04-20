package com.marlena.agenda.core

import android.app.Application
import com.marlena.agenda.persistence.AgendaDB
import com.marlena.agenda.service.WeatherClient

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        AgendaDB.initialize(this)
        WeatherClient.initialize()

    }
}