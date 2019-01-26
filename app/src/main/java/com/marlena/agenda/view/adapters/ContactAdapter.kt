package com.marlena.agenda.view.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marlena.agenda.R
import com.marlena.agenda.model.Contact
import com.marlena.agenda.persistence.AgendaDB
import com.marlena.agenda.view.activities.ContactListActivity
import kotlinx.android.synthetic.main.item_contact.view.*


class ContactAdapter (private val contacts: List<Contact>,
                      private val contactView: ContactInterface.View) : Adapter<ContactAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val contact = contacts[position]
        holder.bindView(contact, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(contactView.getContext()).inflate(R.layout.item_contact, parent, false)
        return ViewHolder(view, contactView)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    class ViewHolder (itemView: View, val contactView: ContactInterface.View): RecyclerView.ViewHolder(itemView) {

        fun bindView(contact: Contact, position: Int) {
            itemView.contact_nameTXT.text = contact.name
            itemView.contact_phoneTXT.text = contact.phone
            itemView.contact_ageTXT.text = contact.age
            itemView.contact_surnameTXT.text = contact.surname

            itemView.delete_contactBTN.setOnClickListener{
                contactView.removeContact(position)
            }

            itemView.edit_contactBTN.setOnClickListener{
                contactView.editContact(position)
            }

            itemView.itemCV.setOnClickListener {
                if (!contact.seeDetais) {
                    itemView.contact_ageTXT.visibility = View.VISIBLE
                    itemView.contact_surnameTXT.visibility = View.VISIBLE
                    itemView.delete_contactBTN.visibility = View.VISIBLE
                    itemView.edit_contactBTN.visibility = View.VISIBLE
                    contact.seeDetais = true
                } else {
                    itemView.contact_ageTXT.visibility = View.GONE
                    itemView.contact_surnameTXT.visibility = View.GONE
                    itemView.delete_contactBTN.visibility = View.GONE
                    itemView.edit_contactBTN.visibility = View.GONE
                    contact.seeDetais = false
                }
            }
        }
    }
}