package com.marlena.agenda.view.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.marlena.agenda.view.adapters.ContactAdapter
import com.marlena.agenda.R
import com.marlena.agenda.data.Cache
import com.marlena.agenda.model.Contact
import com.marlena.agenda.persistence.AgendaDB
import kotlinx.android.synthetic.main.activity_contact_list.*

class ContactListActivity : AppCompatActivity() {

//    companion object {
//        const val CONTACTLIST_ARG = "contactlist_arg"
//    }

    private val contactList = ArrayList<Contact>()
    private var adapter: ContactAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)

        adapter = ContactAdapter(contactList, this)

        val layoutManager = LinearLayoutManager(this)
        contato_list_recyclerview?.layoutManager = layoutManager
        contato_list_recyclerview.adapter = adapter

        updateList()
//        getArgs()
    }

    private fun updateList(){
        AgendaDB.instance.contactDAO().getContacts()?.let {
            contactList.addAll(it)
            adapter?.notifyDataSetChanged()
        }
    }

//    private fun getArgs() {
//        val contact_list = Cache.contactList
//
//        contact_list?.let { contactList.addAll(it) }
//        adapter?.notifyDataSetChanged()
//    }

//    private fun getContacts(): List<Contact>{
//        return listOf(
//            Contact(
//                "Marlena",
//                "99154-5496"
//            ),
//            Contact(
//                "Mario",
//                "3391-3397"
//            ),
//            Contact(
//                "Flavio",
//                "99948-4822"
//            ))
//    }
}