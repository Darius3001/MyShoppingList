package com.example.myshoppinglist.domain.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myshoppinglist.domain.model.ShoppingListEntry

@Database(entities = [ShoppingListEntry::class], version = 1, exportSchema = false)
abstract class ShoppingListDatabase : RoomDatabase() {
    abstract fun shoppingListDao(): ShoppingListDao

    companion object {
        val DATABASE_NAME = "shopping_list_database"
    }
}