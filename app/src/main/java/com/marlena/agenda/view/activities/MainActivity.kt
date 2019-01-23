package com.marlena.agenda.view.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.marlena.agenda.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    companion object {
//        const val CONTACT_ARG = "contact_arg"
//        const val ADDCONTACT_CODE = 30
//    }

//    private lateinit var contactList: ArrayList<Contact>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add_contato_pageTXT.setOnClickListener {
            goToAddContactListActivity()
        }
        ver_contatosTXT.setOnClickListener {
            goToContactListActivity()
        }

//        contactList = ArrayList()
    }

    private fun goToAddContactListActivity() {
        val intent = Intent(this, AddContactActivity::class.java)
//        startActivityForResult(intent, ADDCONTACT_CODE)
        startActivity(intent)
    }

    private fun goToContactListActivity() {
//        Cache.contactList = contactList

        val intent = Intent(this, ContactListActivity::class.java)
        startActivity(intent)
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == ADDCONTACT_CODE && resultCode == Activity.RESULT_OK) {
//            data?.let { getArgs(it, CONTACT_ARG) }
//        }
//    }
//
//    private fun getArgs(intent: Intent, arg: String) {
//        val contact = intent.getSerializableExtra(arg) as Contact?
//
//        contact?.let {
//            Toast.makeText(this, it.name, Toast.LENGTH_LONG).show()
//            contactList.add(it)
//        }
//    }
}