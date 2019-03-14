package com.marlena.agenda.scenes.contactList

import com.marlena.agenda.adapters.ContactAdapter
import com.marlena.agenda.persistence.AgendaDB
import com.marlena.agenda.data.Cache
import com.marlena.agenda.data.Cache.Companion.contactList

class ContactListPresenter (val view: ContactList.View): ContactList.Presenter {

    override fun requestMessage() {
        view.showMessage("Message!")
    }

    override fun updateList() {
        AgendaDB.instance.contactDAO().getContacts()?.let {
            Cache.contactList?.clear()
            Cache.contactList?.addAll(it)
        }
    }
    override fun deleteContact(position: Int) {
        Cache.contactList?.get(position)?.let {
            AgendaDB.instance.contactDAO().delete(it)
            Cache.contactList?.removeAt(position)
        }
    }
}