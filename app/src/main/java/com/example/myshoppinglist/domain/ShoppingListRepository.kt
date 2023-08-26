package com.example.myshoppinglist.domain

import com.example.myshoppinglist.domain.datasource.ShoppingListDBEntry
import com.example.myshoppinglist.domain.datasource.ShoppingListDao
import kotlinx.coroutines.flow.Flow

class ShoppingListRepository(
    private val dao: ShoppingListDao
) {
    fun getShoppingList(): Flow<List<ShoppingListDBEntry>> = dao.getAllItems()
}