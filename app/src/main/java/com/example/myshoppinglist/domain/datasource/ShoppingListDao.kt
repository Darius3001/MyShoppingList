package com.example.myshoppinglist.domain.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myshoppinglist.domain.model.ShoppingListEntry
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface ShoppingListDao {
    @Query("SELECT * FROM shopping_list")
    fun getAllItems(): Flow<List<ShoppingListEntry>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(entry: ShoppingListEntry)

    @Query("DELETE FROM shopping_list WHERE uuid = :uuid")
    suspend fun deleteByUuid(uuid: UUID)

    @Query("UPDATE shopping_list SET checked = :checked WHERE uuid = :uuid")
    suspend fun setChecked(uuid: UUID, checked: Boolean)
}