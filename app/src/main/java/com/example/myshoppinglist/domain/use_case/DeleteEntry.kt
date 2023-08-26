package com.example.myshoppinglist.domain.use_case

import com.example.myshoppinglist.domain.ShoppingListRepository
import java.util.UUID

class DeleteEntry(
    private val repository: ShoppingListRepository
) {
    suspend operator fun invoke(uuid: UUID) {
        repository.removeItem(uuid)
    }
}