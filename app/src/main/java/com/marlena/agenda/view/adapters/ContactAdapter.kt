package com.marlena.agenda.view.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marlena.agenda.R
import com.marlena.agenda.model.Contact
import kotlinx.android.synthetic.main.item_contact.view.*


class ContactAdapter (private val contacts: List<Contact>,
                      private val context:Context) : Adapter<ContactAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val contact = contacts[position]
        holder.bindView(contact)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindView(contact: Contact) {
            val name = itemView.contact_nameTXT
            val phone = itemView.contact_phoneTXT
            val age = itemView.contact_ageTXT
            val surname = itemView.contact_surnameTXT

            itemView.itemCV.setOnClickListener {
                age.text = contact.age
                surname.text = contact.surname
                itemView.contact_ageTXT.visibility = View.VISIBLE
                itemView.contact_surnameTXT.visibility = View.VISIBLE
            }

            name.text = contact.name
            phone.text = contact.phone
            itemView.contact_ageTXT.visibility = View.GONE
            itemView.contact_surnameTXT.visibility = View.GONE
        }
    }
}