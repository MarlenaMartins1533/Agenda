package com.marlena.agenda.view.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marlena.agenda.R
import com.marlena.agenda.model.Contact
import kotlinx.android.synthetic.main.activity_contact.view.*


class ContactAdapter (private val contacts: List<Contact>,
                      private val context:Context) : Adapter<ContactAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val contact = contacts[position]
        holder.bindView(contact)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_contact, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindView(contact: Contact) {
            val name = itemView.contact_nameTXT
            val phone = itemView.contact_phoneTXT

            name.text = contact.name
            phone.text =contact.phone
        }
    }
}