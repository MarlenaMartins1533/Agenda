package com.marlena.agenda.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "contact")
class Contact: Serializable{

    @PrimaryKey @ColumnInfo(name = "phone")
    var phone:String = ""
    @ColumnInfo(name = "name")
    var name:String = ""
    @ColumnInfo(name = "age")
    var age: String = ""
    @ColumnInfo(name = "surname")
    var surname: String = ""
    @Ignore
    var seeDetais: Boolean = false

    fun getCompleteName(): String {
        return name + surname
    }
}