package com.example.roomdatabasepart2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.room.Room
import com.example.roomdatabasepart2.Database.ContactDatabase
import com.example.roomdatabasepart2.Entity.Contact
import com.example.roomdatabasepart2.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        database = Room.databaseBuilder(
            applicationContext,
            ContactDatabase::class.java,
            "ContactDatabase"
        ).build()
        GlobalScope.launch {
            database.dbContact()
        }
        GlobalScope.launch {
            database.dbContact().insertContact(Contact(0, "John", "988976675"))
        }
    }




        fun getData(view: View) {
            database.dbContact().getAllContact().observe(this, Observer {
                Log.d("FAIZAN", it.toString())
            })

        }
    }

