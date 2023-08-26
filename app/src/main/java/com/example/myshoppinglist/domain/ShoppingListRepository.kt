package com.example.myshoppinglist.domain

import com.example.myshoppinglist.domain.model.ShoppingListEntry
import com.example.myshoppinglist.domain.datasource.ShoppingListDao
import kotlinx.coroutines.flow.Flow
import java.util.UUID

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

    suspend fun removeItem(uuid: UUID) = dao.deleteByUuid(uuid.toString())
}