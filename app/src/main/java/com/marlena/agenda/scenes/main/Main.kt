package com.marlena.agenda.scenes.main

import com.marlena.agenda.scenes.Scene

interface Main{
    interface View: Scene.View {
        fun showMessage(message: String)
    }

    interface Presenter: Scene.Presenter {
        fun requestMessage()
    }
}