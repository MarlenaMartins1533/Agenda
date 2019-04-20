package com.marlena.agenda.scenes.contactList

import com.marlena.agenda.adapters.ContactAdapter
import com.marlena.agenda.persistence.AgendaDB
import com.marlena.agenda.model.Contact
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class ContactListPresenter (val view: ContactList.View): ContactList.Presenter, CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Main + SupervisorJob()
    private var job: Job? = null

    override fun requestMessage() {
        view.showMessage("Message!")
    }

    override fun getList(){
        launch {
            val contactList = ArrayList<Contact>()

            withContext(Dispatchers.IO){
                AgendaDB.instance.contactDAO().getContacts()?.let {
                    contactList.addAll(it)
                }
            }
            view.setList(contactList)
        }
    }

    override fun deleteContact(contact: Contact) {
        launch (Dispatchers.IO){ AgendaDB.instance.contactDAO().delete(contact) }
    }
}