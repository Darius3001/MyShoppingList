package com.example.myshoppinglist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myshoppinglist.domain.model.ShoppingListEntry
import com.example.myshoppinglist.domain.use_case.ShoppingListUseCases
import com.example.myshoppinglist.ui.ShoppingListEvent
import dagger.hilt.android.lifecycle.HiltViewModel
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

    fun onEvent(event: ShoppingListEvent) {
        when (event) {
            is ShoppingListEvent.AddEntry -> {
                viewModelScope.launch {
                    useCases.addEntry(event.text)
                }
            }
            is ShoppingListEvent.DeleteEntry -> {
                viewModelScope.launch {
                    useCases.deleteEntry(event.uuid)
                }
            }
            is ShoppingListEvent.SetChecked -> {
                viewModelScope.launch {
                    useCases.setChecked(event.uuid, event.checked)
                }
            }
        }
    }

}