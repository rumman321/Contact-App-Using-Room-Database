package com.example.contact_app

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class ContactDatabase :RoomDatabase(){
    abstract fun contactDao():ContactDao

    companion object{
        @Volatile
        private var INSTANCE:ContactDatabase?=null

        fun getdatabase(context: Context):ContactDatabase{
            val tempinstance= INSTANCE
            if (tempinstance !=null) {
                return tempinstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContactDatabase::class.java,
                    "student_database"

                ).build()
                INSTANCE=instance
                return instance
            }
        }

    }
}