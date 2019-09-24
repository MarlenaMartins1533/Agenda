package com.marlena.agenda.scenes.addContact

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.marlena.agenda.R
import com.marlena.agenda.model.Contact
import kotlinx.android.synthetic.main.activity_add_contact.*

class AddContactActivity : AppCompatActivity(), AddContact.View {

    companion object {
        const val OLDCONTACT_ARG = "OLDCONTACT_ARG"
    }

    private lateinit var presenter: AddContact.Presenter
    private var oldContact: Contact?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        presenter = AddContactPresenter(this)
        oldContact = intent.getSerializableExtra(OLDCONTACT_ARG) as Contact?

        setEdts(oldContact)

        add_contactBTN.setOnClickListener {
            if (oldContact == null) { //create new contact
                val contact = getEdts()


                try {
                    presenter.insertContact(contact)
                    presenter.requestMessage(contact)
                }
                catch (e:Exception){ showMessage("Contact already exists") }

                finish()
            }
            else { //contact edition
                val contact = getEdts()

                oldContact?.let { old -> presenter.deleteContact(old) }

                presenter.insertContact(contact)
                presenter.requestMessage(contact)
                finish()
            }
        }

    }

    private fun getEdts(): Contact {
        val contact = Contact()

        contact.name = name_contactEDT.text.toString()
        contact.phone = phone_contactEDT.text.toString()
        contact.age = age_contactEDT.text.toString()
        contact.surname = surname_contactEDT.text.toString()
        return contact
    }

    private fun setEdts(contact: Contact?) {
        contact?.let {
            name_contactEDT.setText(it.name)
            phone_contactEDT.setText(it.phone)
            age_contactEDT.setText(it.age)
            surname_contactEDT.setText(it.surname)
        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun getViewContext(): Context? {
        return this
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
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