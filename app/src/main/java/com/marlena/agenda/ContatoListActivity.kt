package com.marlena.agenda
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_contato_list.*

class ContatoListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contato_list)

        val layoutManager = LinearLayoutManager(this)
        contato_list_recyclerview.layoutManager = layoutManager
        contato_list_recyclerview.adapter = ContatoListAdapter(contatos(),this)
    }

    private fun contatos(): List<Contato>{
            return listOf(
                Contato(
                    "Marlena",
                    "99154-5496"
                ),
                Contato(
                    "Mario",
                    "3391-3397"
                ),
                Contato(
                    "Flavio",
                    "99948-4822"
                ))
    }
}