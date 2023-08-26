package com.example.myshoppinglist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myshoppinglist.domain.ShoppingListRepository
import com.example.myshoppinglist.domain.model.ShoppingListEntry
import com.example.myshoppinglist.domain.use_case.ShoppingListUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingListViewModel @Inject constructor(
    private val useCases: ShoppingListUseCases
) : ViewModel() {
    private val _content: MutableState<List<ShoppingListEntry>> = mutableStateOf(emptyList())
    val content: State<List<ShoppingListEntry>> = _content

    init {
        viewModelScope.launch {
            useCases.getShoppingList().collect {
                _content.value = it
            }
        }
    }

    fun addRandom() {
        viewModelScope.launch {
            useCases.addEntry("random")
        }
    }
}