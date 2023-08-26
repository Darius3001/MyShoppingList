package com.example.myshoppinglist.domain.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingListDao {
    @Query("SELECT * FROM shopping_list")
    fun getAllItems(): Flow<List<ShoppingListDBEntry>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(entry: ShoppingListDBEntry)

    @Query("DELETE FROM shopping_list WHERE uuid=:uuid")
    suspend fun deleteByUuid(uuid: String)
}