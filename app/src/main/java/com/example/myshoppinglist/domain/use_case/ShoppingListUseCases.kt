package com.example.myshoppinglist.domain.use_case

data class ShoppingListUseCases(
    val addEntry: AddEntry,
    val deleteEntry: DeleteEntry,
    val getShoppingList: GetShoppingList
)
