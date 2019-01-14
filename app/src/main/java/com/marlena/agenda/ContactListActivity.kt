package com.marlena.agenda
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_contact_list.*

class ContactListActivity : AppCompatActivity() {

    companion object {
        const val CONTACT_ARG = "contact_arg"
    }

    private val contactList = ArrayList<Contact>()
    private var adapter: ContactAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)

        contactList.addAll(getContacts())

        adapter = ContactAdapter(contactList,this)

        val layoutManager = LinearLayoutManager(this)
        contato_list_recyclerview.layoutManager = layoutManager
        contato_list_recyclerview.adapter = adapter

        getArgs()
    }

    private fun getArgs() {
        val contact = intent.getSerializableExtra(CONTACT_ARG) as Contact?

        if (contact != null) {
            contactList.add(contact)
            adapter?.notifyDataSetChanged()
        }
    }

    private fun getContacts(): List<Contact>{
        return listOf(
            Contact(
                "Marlena",
                "99154-5496"
            ),
            Contact(
                "Mario",
                "3391-3397"
            ),
            Contact(
                "Flavio",
                "99948-4822"
            ))
    }
}