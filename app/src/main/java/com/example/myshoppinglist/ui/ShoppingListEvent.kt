package com.example.myshoppinglist.ui

import java.util.UUID

sealed class ShoppingListEvent {
    data class AddEntry(val text: String) : ShoppingListEvent()
    data class DeleteEntry(val uuid: UUID) : ShoppingListEvent()
    data class SetChecked(val uuid: UUID, val checked: Boolean) : ShoppingListEvent()
}
