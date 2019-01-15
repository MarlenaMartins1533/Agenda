package com.marlena.agenda.model

import java.io.Serializable

data class Contact (val name:String,
                    val phone:String): Serializable{

    var age: Int? = null
    var surname: String? = null
}