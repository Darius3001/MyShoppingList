package com.example.myshoppinglist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.myshoppinglist.domain.ShoppingListRepository
import com.example.myshoppinglist.domain.model.ShoppingListEntry
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShoppingListViewModel @Inject constructor(
    private val repository: ShoppingListRepository
) : ViewModel() {
    private val _content: MutableState<List<ShoppingListEntry>> = mutableStateOf(listOf(
        ShoppingListEntry(text = "abc", checked = true)
    ))
    val content: State<List<ShoppingListEntry>> = _content

}