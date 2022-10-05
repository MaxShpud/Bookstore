package com.example.bookstore.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bookstore.model.accounts.room.entities.AccountDbEntity

@Database(
    version = 1,
    entities = [
        AccountDbEntity::class
    ]
)
abstract class AppDatabase : RoomDatabase() {


}