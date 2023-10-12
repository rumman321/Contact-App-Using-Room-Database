package com.example.contact_app

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contact_Information" )
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id:Int?,
    @ColumnInfo(name = "name")
    val Name:String?,
    @ColumnInfo(name = "email")
    val Email:String?,
    @ColumnInfo(name = "phone")
    val Phone:Int?,

)
