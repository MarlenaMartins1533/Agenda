package com.marlena.agenda.view.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.marlena.agenda.R
import com.marlena.agenda.model.Contact
import com.marlena.agenda.persistence.AgendaDB
import com.marlena.agenda.persistence.ContactDAO_Impl
import kotlinx.android.synthetic.main.activity_add_contact.*

class AddContactActivity : AppCompatActivity() {

    companion object {
        const val OLDCONTACT_ARG = "OLDCONTACT_ARG"
    }

    private var oldContact: Contact?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        oldContact = intent.getSerializableExtra(OLDCONTACT_ARG) as Contact?

        oldContact?.let {
            name_contactEDT.setText(it.name)
            phone_contactEDT.setText(it.phone)
            age_contactEDT.setText(it.age)
            surname_contactEDT.setText(it.surname)
        }

        add_contactBTN.setOnClickListener {
            if (oldContact == null) {

                val contact = Contact()
                contact.name = name_contactEDT.text.toString()
                contact.phone = phone_contactEDT.text.toString()
                contact.age = age_contactEDT.text.toString()
                contact.surname = surname_contactEDT.text.toString()

                AgendaDB.instance.contactDAO().insert(contact)
                Toast.makeText(this, contact.name, Toast.LENGTH_LONG).show()

//            goToMainActivity(contact)
                finish()
            }
            else {
                val contact = Contact()

                oldContact?.let {
                    AgendaDB.instance.contactDAO().delete(it)
                }

                contact.name = name_contactEDT.text.toString()
                contact.phone = phone_contactEDT.text.toString()
                contact.age = age_contactEDT.text.toString()
                contact.surname = surname_contactEDT.text.toString()

                AgendaDB.instance.contactDAO().insert(contact)
                Toast.makeText(this, contact.name, Toast.LENGTH_LONG).show()

//            goToMainActivity(contact)
                finish()
                }
            }

        }
    }

//    private fun goToMainActivity (contact: Contact){
//        val intent = Intent(this, MainActivity::class.java)
//        intent.putExtra(MainActivity.CONTACTLIST_ARG, contact)
//        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//        startActivity(intent)
//
//        val intent = Intent()
//        intent.putExtra(MainActivity.CONTACT_ARG, contact)
//        setResult(Activity.RESULT_OK, intent)
//
//        finish()
//    } }