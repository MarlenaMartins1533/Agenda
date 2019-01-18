package com.marlena.agenda.model

import java.io.Serializable

data class Contact (val name:String,
                    val phone:String): Serializable{

    var age: String? = "Age"
    var surname: String? = "Surname" // Valor zerado para demonstração
}