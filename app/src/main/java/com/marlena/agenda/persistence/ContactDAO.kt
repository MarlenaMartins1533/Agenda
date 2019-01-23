package com.marlena.agenda.persistence

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.marlena.agenda.model.Contact

@Dao
interface ContactDAO {

    @Query("SELECT * FROM contact")
    fun getContacts(): List<Contact>?

    @Insert
    fun insert(contact: Contact)

    @Delete
    fun delete(contact: Contact)
}