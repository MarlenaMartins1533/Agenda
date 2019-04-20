package com.marlena.agenda.adapters

import android.content.Context
import com.marlena.agenda.model.Contact

interface ContactInterface {
    interface View {
        fun removeContact(contact: Contact)
        fun editContact(position: Int)
        fun getContext(): Context?
    }
    interface Presenter {
    }
}