package com.marlena.agenda

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val CONTACT_ARG = "contact_arg"
    }

    private var contact: Contact? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add_contato_pageTXT.setOnClickListener {
            goToAddContactListActivity()
        }
        ver_contatosTXT.setOnClickListener {
            goToContactListActivity()
        }

        contact = intent.getSerializableExtra(CONTACT_ARG) as Contact?

        if (contact != null) {
            Toast.makeText(this, contact?.name, Toast.LENGTH_LONG).show()
        }
    }

    private fun goToAddContactListActivity() {
        val intent = Intent(this, AddContactActivity::class.java)
        startActivity(intent)
    }

    private fun goToContactListActivity() {
        val intent = Intent(this, ContactListActivity::class.java)
        intent.putExtra(ContactListActivity.CONTACT_ARG, contact)
        startActivity(intent)
    }
}