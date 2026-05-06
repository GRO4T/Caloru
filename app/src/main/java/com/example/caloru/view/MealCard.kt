package com.example.caloru.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.caloru.R
import com.example.caloru.model.TrackedItemConsumable
import com.example.caloru.viewmodel.TrackerEvent

@Composable
fun MealCard(
    name: String,
    trackedItemConsumables: List<TrackedItemConsumable>,
    onEvent: (TrackerEvent) -> Unit
) {
    var isExpanded by rememberSaveable { mutableStateOf(true) }

    Column {
        Row {
            Text(name)
            IconButton(onClick = {
                isExpanded = !isExpanded;
            }) {
                Icon(
                    painter = painterResource(R.drawable.arrow_drop_down_24dp_1f1f1f_fill0_wght400_grad0_opsz24),
                    contentDescription = "dropdown"
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = {
                onEvent(TrackerEvent.ShowAddTrackedItemDialog(name))
            }) {
                Icon(
                    painter = painterResource(R.drawable.add_24dp_1f1f1f_fill0_wght400_grad0_opsz24),
                    contentDescription = "add"
                )
            }
        }
        AnimatedVisibility(visible = isExpanded) {
            Column {
                trackedItemConsumables.forEach { item ->
                    TrackedItemCard(item)
                }
            }
        }
    }
}
