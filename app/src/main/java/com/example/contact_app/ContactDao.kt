package com.example.contact_app

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface ContactDao {
    @Query( "SELECT* FROM Contact_Information")

    fun getAll():List<Contact>

    @Insert(onConflict= OnConflictStrategy.IGNORE)
    suspend fun insert(contact: Contact)

}