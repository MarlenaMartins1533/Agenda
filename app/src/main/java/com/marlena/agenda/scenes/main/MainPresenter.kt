package com.marlena.agenda.scenes.main

class MainPresenter(val view: Main.View): Main.Presenter {

    override fun requestMessage() {
        view.showMessage("Message!")
    }

}