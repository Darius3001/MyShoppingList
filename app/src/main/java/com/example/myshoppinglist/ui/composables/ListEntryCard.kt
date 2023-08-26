package com.example.myshoppinglist.ui.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
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
    entry: ShoppingListEntry,
    onDeleteEntry: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 64.dp)
            .padding(vertical = 4.dp)
            .border(1.dp, Color.LightGray, RoundedCornerShape(2.dp))
            .clickable {
                onDeleteEntry()
            }
    ) {
        Text(text = entry.text)
    }
}