package com.marlena.agenda

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_contato.view.*


class ContatoListAdapter (private val contatos: List<Contato>,
                       private val context:Context) : Adapter<ContatoListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val contato = contatos[position]
        holder.bindView(contato)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_contato, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contatos.size
    }

    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindView(contato: Contato) {
            val nome = itemView.contato_nomeTXT
            val telefone = itemView.contato_telefoneTXT

            nome.text = contato.nome
            telefone.text =contato.telefone
        }
    }
}