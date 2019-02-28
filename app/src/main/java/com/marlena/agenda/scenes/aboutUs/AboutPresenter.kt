package com.marlena.agenda.scenes.aboutUs

class AboutPresenter(val view: About.View): About.Presenter {

    override fun requestMessage() {
        view.showMessage("Message!")
    }

}
