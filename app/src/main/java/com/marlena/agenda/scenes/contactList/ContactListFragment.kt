package com.marlena.agenda.scenes.contactList

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.marlena.agenda.adapters.ContactAdapter
import com.marlena.agenda.R
import com.marlena.agenda.model.Contact
import com.marlena.agenda.scenes.addContact.AddContactActivity
import com.marlena.agenda.adapters.ContactInterface
import kotlinx.android.synthetic.main.fragment_contact_list.*


class ContactListFragment : Fragment(), ContactInterface.View, ContactList.View {
    
    companion object {
        //const val CONTACTLIST_ARG = "contactlist_arg"
        fun newInstance(): ContactListFragment {
            return ContactListFragment()
        }
    }

    private lateinit var presenter: ContactList.Presenter
    private val contactList: MutableList<Contact> by lazy { mutableListOf<Contact>() }
    private var adapter: ContactAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = ContactListPresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_contact_list,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ContactAdapter(contactList, this)

        val layoutManager = LinearLayoutManager(context)
        contato_list_recyclerview?.layoutManager = layoutManager
        contato_list_recyclerview.adapter = adapter
    }

    override fun showMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun getViewContext(): Context? {
        return context
    }

    override fun showError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        presenter.getList()
    }

    override fun setList(contactList: ArrayList<Contact>) {
        this.contactList.clear()
        this.contactList.addAll(contactList)
        adapter?.notifyDataSetChanged()
    }

    override fun editContact(position: Int){
        val intent = Intent(context, AddContactActivity::class.java)
        intent.putExtra(AddContactActivity.OLDCONTACT_ARG, contactList[position])
        startActivity(intent)
    }

    override fun removeContact(contact: Contact) {
        presenter.deleteContact(contact)
        presenter.getList()
    }
}
//    private fun goToAddContactListActivity() {
//        val intent = Intent(context, AddContactActivity::class.java)
////        startActivityForResult(intent, ADDCONTACT_CODE)
//        startActivity(intent)
//    }
