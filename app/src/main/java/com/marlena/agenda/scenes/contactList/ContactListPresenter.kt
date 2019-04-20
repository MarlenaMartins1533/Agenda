package com.marlena.agenda.scenes.contactList

import com.marlena.agenda.adapters.ContactAdapter
import com.marlena.agenda.persistence.AgendaDB
import com.marlena.agenda.model.Contact

class ContactListPresenter (val view: ContactList.View): ContactList.Presenter {

    override fun requestMessage() {
        view.showMessage("Message!")
    }

    override fun getList(): ArrayList<Contact> {
        val contactList = ArrayList<Contact>()

        AgendaDB.instance.contactDAO().getContacts()?.let {
            contactList.addAll(it)
        }
        return contactList
    }
    override fun deleteContact(contact: Contact) {
        AgendaDB.instance.contactDAO().delete(contact)
    }
}