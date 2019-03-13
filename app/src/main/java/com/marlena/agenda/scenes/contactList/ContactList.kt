package com.marlena.agenda.scenes.contactList

import android.widget.Adapter
import com.marlena.agenda.adapters.ContactAdapter
import com.marlena.agenda.model.Contact
import com.marlena.agenda.scenes.Scene

interface ContactList {
    interface View: Scene.View {
        fun showMessage(message: String)
    }

    interface Presenter: Scene.Presenter {
        fun requestMessage()
        fun deleteContact(position: Int, adapter: ContactAdapter)
        fun updateList(adapter: ContactAdapter)
    }
}