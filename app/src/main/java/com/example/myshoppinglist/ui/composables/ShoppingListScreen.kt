package com.example.myshoppinglist.ui.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.myshoppinglist.ShoppingListViewModel

@Composable
fun ShoppingListScreen(viewModel: ShoppingListViewModel) {
    LazyColumn {
        items(viewModel.content.value) {
            Text(it.text)
        }
        item { 
            Button(onClick = { viewModel.addRandom() }) {
                Text(text = "add random")
            }
        }
    }
}