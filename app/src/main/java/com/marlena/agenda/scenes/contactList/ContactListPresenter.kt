package com.marlena.agenda.scenes.contactList

class ContactListPresenter (val view: ContactList.View): ContactList.Presenter {

    override fun requestMessage() {
        view.showMessage("Message!")
    }

}