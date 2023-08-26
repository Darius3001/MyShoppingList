package com.example.myshoppinglist.ui.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.myshoppinglist.ShoppingListViewModel
import com.example.myshoppinglist.ui.ShoppingListEvent

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun ShoppingListScreen(viewModel: ShoppingListViewModel) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp)
            .padding(bottom = 12.dp)
    ) {
        val (column, input, floatingActionButton) = createRefs()

        LazyColumn(
            modifier = Modifier
                .constrainAs(column) {
                    top.linkTo(parent.top)
                    bottom.linkTo(input.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)

                    height = Dimension.fillToConstraints
                }
        ) {
            items(
                viewModel.content.value,
                key = { it.uuid }
            ) { entry ->
                ListEntryCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .animateItemPlacement(),
                    entry = entry,
                    onDeleteEntry = {
                        viewModel.onEvent(ShoppingListEvent.DeleteEntry(entry.uuid))
                    },
                    onCheck = {
                        viewModel.onEvent(ShoppingListEvent.SetChecked(entry.uuid, it))
                    }
                )
            }
        }

        var inputText by remember { mutableStateOf("") }

        TextField(
            modifier = Modifier.constrainAs(input) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(floatingActionButton.start, margin = 6.dp)

                width = Dimension.fillToConstraints
            },
            value = inputText,
            onValueChange = { inputText = it }
        )

        FloatingActionButton(
            modifier = Modifier.constrainAs(floatingActionButton) {
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
            },
            onClick = {
                viewModel.onEvent(ShoppingListEvent.AddEntry(inputText))
                inputText = ""
            }
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null)
        }
    }
}