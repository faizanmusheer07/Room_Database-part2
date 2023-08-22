package com.example.roomdatabasepart2.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomdatabasepart2.Dao.ContactDao
import com.example.roomdatabasepart2.Entity.Contact




@Database(entities = [Contact::class], version = 1, exportSchema = false)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun dbContact() : ContactDao
}