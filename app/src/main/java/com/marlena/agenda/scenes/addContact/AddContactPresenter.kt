package com.marlena.agenda.scenes.addContact

import com.marlena.agenda.model.Contact
import com.marlena.agenda.persistence.AgendaDB

class AddContactPresenter(val view: AddContact.View): AddContact.Presenter  {

    override fun requestMessage(contact: Contact) {
        val name = contact.name
        view.showMessage("$name added successfully!")
    }

    override fun insertContact(contact: Contact) {
        AgendaDB.instance.contactDAO().insert(contact)
    }

    override fun deleteContact(contact: Contact) {
        AgendaDB.instance.contactDAO().delete(contact)
    }

}