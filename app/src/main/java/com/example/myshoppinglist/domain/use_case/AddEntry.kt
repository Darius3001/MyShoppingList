package com.example.myshoppinglist.domain.use_case

import com.example.myshoppinglist.domain.ShoppingListRepository

class AddEntry(
    private val repository: ShoppingListRepository
) {
    suspend operator fun invoke(text: String) {

    }
}