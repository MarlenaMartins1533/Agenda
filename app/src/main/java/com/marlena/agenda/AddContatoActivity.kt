package com.marlena.agenda
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_contato.*
import android.view.View
import android.widget.*

class AddContatoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contato)

        // get reference to all views
        var nome_contatoTXT = findViewById(R.id.nome_contatoTXT) as EditText
        var tel_contatoTXT = findViewById(R.id.tel_contatoTXT) as EditText
        var add_contatoTXT = findViewById(R.id.add_contatoTXT) as Button


        // set on-click listener
        add_contatoTXT.setOnClickListener {
            addContatoPage()
        }
    }

    private fun addContatoPage () {
        val intent = Intent(this, AddContatoActivity::class.java)
        startActivity(intent)

    }
}
/* val nome_contatoTXT = nome_contatoTXT.text;
            val tel_contatoTXT = tel_contatoTXT.text;

            //falta implementar o botão
            //Toast.makeText(this@AddContatoActivity, nome_contatoTXT, Toast.LENGTH_LONG).show()
*/
//Esse é o arquivo que salvará o contato