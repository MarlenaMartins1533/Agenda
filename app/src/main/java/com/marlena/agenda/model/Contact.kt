package com.marlena.agenda.model

import java.io.Serializable

data class Contact (val name:String,
                    val phone:String,
                    val age: String): Serializable{

    var surname: String? = "EMPTY" // Valor zerado para demonstração
}