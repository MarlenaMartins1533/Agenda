package com.marlena.agenda

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add_contato_pageTXT.setOnClickListener {
            //vai para
        }
        ver_contatosTXT.setOnClickListener {
            verContato()
        }
    }

    private fun verContato () {
     // tem que mostrar a lista
        val intent = Intent(this, ContatoListActivity::class.java)
        startActivity(intent)

    }
}

