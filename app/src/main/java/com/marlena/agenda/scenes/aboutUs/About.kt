package com.marlena.agenda.scenes.aboutUs

import com.marlena.agenda.scenes.Scene

interface About{
    interface View: Scene.View {
        fun showMessage(message: String)
    }

    interface Presenter: Scene.Presenter {
        fun getWeather()
        fun requestMessage()
        fun kill()
    }
}
