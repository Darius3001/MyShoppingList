package com.example.myshoppinglist.domain.datasource

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "shopping_list")
class ShoppingListEntry(
    @PrimaryKey val uuid: UUID = UUID.randomUUID(),
    val text: String,
    val checked: Boolean
)