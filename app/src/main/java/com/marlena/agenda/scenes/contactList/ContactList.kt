package com.marlena.agenda.scenes.contactList

import com.marlena.agenda.scenes.Scene

interface ContactList {
    interface View: Scene.View {
        fun showMessage(message: String)
    }

    interface Presenter: Scene.Presenter {
        fun requestMessage()
    }
}