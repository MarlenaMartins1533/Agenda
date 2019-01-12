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

        add_contatoTXT.setOnClickListener {
            addContato()
        }
        ver_contatosTXT.setOnClickListener {
            verContato()
        }
    }

    private fun addContato () {
        val intent = Intent(this, AddContatoActivity::class.java)
        startActivity(intent)

    }
    private fun verContato () {
     //   val intent = Intent(this, VerContatoActivity::class.java)
        startActivity(intent)

    }
}

