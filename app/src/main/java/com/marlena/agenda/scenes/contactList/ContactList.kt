package com.marlena.agenda.scenes.contactList

import com.marlena.agenda.adapters.ContactAdapter
import com.marlena.agenda.model.Contact
import com.marlena.agenda.scenes.Scene

interface ContactList {
    interface View: Scene.View {
        fun showMessage(message: String)
        fun setList(contactList: ArrayList<Contact>)
    }

    interface Presenter: Scene.Presenter {
        fun requestMessage()
        fun getList()
        fun deleteContact(contact: Contact)
        fun kill()
    }
}