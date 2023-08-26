package com.example.myshoppinglist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable

@Composable
fun ShoppingListScreen(viewModel: ShoppingListViewModel) {
    LazyColumn {
        items(viewModel.content.value) {

        }
    }
}