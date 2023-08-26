package com.example.myshoppinglist.domain

import com.example.myshoppinglist.domain.model.ShoppingListEntry
import com.example.myshoppinglist.domain.datasource.ShoppingListDao
import kotlinx.coroutines.flow.Flow

class ShoppingListRepository(
    private val dao: ShoppingListDao
) {
    fun getShoppingList(): Flow<List<ShoppingListEntry>> = dao.getAllItems()

    suspend fun addItem(text: String, checked: Boolean) = dao.insert(
        ShoppingListEntry(
            text = text,
            checked = checked
        )
    )
}