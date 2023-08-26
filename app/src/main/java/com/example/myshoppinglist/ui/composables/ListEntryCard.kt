package com.example.myshoppinglist.ui.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myshoppinglist.domain.model.ShoppingListEntry

@Composable
fun ListEntryCard(
    modifier: Modifier = Modifier,
    entry: ShoppingListEntry,
    onDeleteEntry: () -> Unit
) {
    Box(
        modifier = modifier
            .border(1.dp, Color.LightGray, RoundedCornerShape(6.dp))
            .clickable {
                onDeleteEntry()
            }
    ) {
        Text(
            modifier = Modifier.padding(4.dp),
            text = entry.text
        )
    }
}