package com.example.myshoppinglist.ui.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myshoppinglist.domain.model.ShoppingListEntry

@Composable
fun ListEntryCard(
    modifier: Modifier = Modifier,
    entry: ShoppingListEntry,
    onDeleteEntry: () -> Unit,
    onCheck: (Boolean) -> Unit
) {
    Box(
        modifier = modifier
            .border(1.dp, Color.LightGray, RoundedCornerShape(6.dp))

    ) {

        Row(
            modifier = Modifier.padding(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = entry.checked,
                onCheckedChange = {
                    onCheck(it)
                }
            )
            Text(
                modifier = Modifier
                    .clickable {
                        onDeleteEntry()
                    },
                text = entry.text
            )
        }
    }
}