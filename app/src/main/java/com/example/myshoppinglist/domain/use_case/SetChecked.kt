package com.example.myshoppinglist.domain.use_case

import com.example.myshoppinglist.domain.ShoppingListRepository
import java.util.UUID

class SetChecked(
    private val repository: ShoppingListRepository
) {
    suspend operator fun invoke(uuid: UUID, checked: Boolean) {
        repository.setChecked(uuid, checked)
    }
}