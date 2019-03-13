package com.marlena.agenda.scenes.contactList

import com.marlena.agenda.adapters.ContactAdapter
import com.marlena.agenda.persistence.AgendaDB
import com.marlena.agenda.data.Cache
import com.marlena.agenda.data.Cache.Companion.contactList

class ContactListPresenter (val view: ContactList.View): ContactList.Presenter {

    override fun requestMessage() {
        view.showMessage("Message!")
    }

    override fun updateList(adapter: ContactAdapter) {
        AgendaDB.instance.contactDAO().getContacts()?.let {
            Cache.contactList.clear()
            contactList.addAll(it)
            adapter.notifyDataSetChanged()
        }
    }
    override fun deleteContact(position: Int, adapter: ContactAdapter) {
        AgendaDB.instance.contactDAO().delete(Cache.contactList[position])
        contactList.removeAt(position)
        adapter.notifyDataSetChanged()
    }
}