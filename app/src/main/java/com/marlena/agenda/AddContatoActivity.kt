package com.marlena.agenda
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_contato.*


class AddContatoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contato)
    }

    private fun contato(): List<Contato> {
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
            )
        )
    }
}
//Esse é o arquivo que salvará o contato