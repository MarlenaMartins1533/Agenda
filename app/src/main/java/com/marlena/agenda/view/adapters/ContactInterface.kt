package com.marlena.agenda.view.adapters

import android.content.Context

interface ContactInterface {
    interface View {
        fun removeContact(position: Int)
        fun editContact(position: Int)
        fun getContext(): Context
    }
    interface Presenter {

    }
}