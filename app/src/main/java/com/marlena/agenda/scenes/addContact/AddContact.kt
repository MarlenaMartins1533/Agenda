package com.marlena.agenda.scenes.addContact

import com.marlena.agenda.model.Contact
import com.marlena.agenda.scenes.Scene

interface AddContact{
    interface View: Scene.View {
        fun showMessage(message: String)
//        fun getEdts()
    }

    interface Presenter: Scene.Presenter {
        fun insertContact(contact: Contact)
        fun deleteContact(contact: Contact)
//        fun requestEdts(contact: Contact)
        fun showMessage(contact: Contact)

    }
}