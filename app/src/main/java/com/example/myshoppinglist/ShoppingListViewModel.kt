package com.example.myshoppinglist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ShoppingListViewModel : ViewModel() {
    private val _content: MutableState<List<ShoppingListEntry>> = mutableStateOf(emptyList())
    val content: State<List<ShoppingListEntry>> = _content

}