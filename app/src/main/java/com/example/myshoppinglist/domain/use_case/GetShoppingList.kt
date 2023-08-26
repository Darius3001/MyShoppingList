package com.example.myshoppinglist.domain.use_case

import com.example.myshoppinglist.domain.ShoppingListRepository
import com.example.myshoppinglist.domain.model.ShoppingListEntry
import kotlinx.coroutines.flow.Flow

class GetShoppingList(
    private val repository: ShoppingListRepository
) {
    operator fun invoke(): Flow<List<ShoppingListEntry>> = repository.getShoppingList()
}