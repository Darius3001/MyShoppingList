package com.example.myshoppinglist.domain.use_case

data class ShoppingListUseCases(
    val getShoppingList: GetShoppingList,
    val addEntry: AddEntry,
    val deleteEntry: DeleteEntry,
    val setChecked: SetChecked
)
