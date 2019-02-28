package com.marlena.agenda.scenes

import android.content.Context

interface Scene {
    interface View {
        fun getViewContext(): Context?
        fun showError(error: String)
    }

    interface Presenter{}

}