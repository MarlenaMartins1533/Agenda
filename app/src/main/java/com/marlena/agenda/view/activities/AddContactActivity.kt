package com.marlena.agenda.view.activities

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.marlena.agenda.R
import com.marlena.agenda.model.Contact
import kotlinx.android.synthetic.main.activity_add_contact.*

class AddContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        add_contactBTN.setOnClickListener {
            val name = name_contactEDT.text.toString()
            val phone = phone_contactEDT.text.toString()
            val contact = Contact(name, phone)

            Toast.makeText(this, contact.name, Toast.LENGTH_LONG).show()

            goToMainActivity(contact)
        }
    }

    private fun goToMainActivity (contact: Contact){
//        val intent = Intent(this, MainActivity::class.java)
//        intent.putExtra(MainActivity.CONTACTLIST_ARG, contact)
//        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//        startActivity(intent)

        val intent = Intent()
        intent.putExtra(MainActivity.CONTACT_ARG, contact)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}