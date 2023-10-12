package com.example.contact_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.contact_app.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var contactDatabase: ContactDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView( binding.root)

        binding.Save.setOnClickListener {
            saveData()
        }
    }

    private fun saveData() {
        val id=binding.batch.text.toString()
       val name=binding.name.text.toString()
       val email=binding.email.text.toString()
       val phone=binding.phone.text.toString()


        if (id.isNotEmpty() && name.isNotEmpty() && email.isNotEmpty()&& phone.isNotEmpty()){
            val contact = Contact(id = null, Name = name, Email = email, Phone = phone.toInt())
            GlobalScope.launch (Dispatchers.IO){
                contactDatabase.contactDao().insert(contact)
            }

            binding.batch.text?.clear()
            binding.name.text?.clear()
            binding.email.text?.clear()
            binding.phone.text?.clear()


            Toast.makeText(this, "Data Save", Toast.LENGTH_SHORT).show()

        }
        else{

            Toast.makeText(this, "Please enter all data", Toast.LENGTH_SHORT).show()}


    }
}