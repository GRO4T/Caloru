package com.example.caloru.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.caloru.viewmodel.TrackerEvent
import com.example.caloru.viewmodel.TrackerState
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.TextButton

@Composable
fun AddConsumableDialog(
    state: TrackerState,
    onEvent: (TrackerEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    fun getTitle(isDish: Boolean): String {
        if (isDish) {
            return "New Dish"
        }
        return "New Product"
    }

    AlertDialog(
        modifier = modifier,
        onDismissRequest = {
            onEvent(TrackerEvent.HideAddConsumableDialog)
        },
        title = { Text(text = getTitle(state.consumableIsDish)) },
        confirmButton = {
            TextButton(
                onClick = {
                    onEvent(TrackerEvent.SaveConsumable)
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onEvent(TrackerEvent.HideAddConsumableDialog)
                }
            ) {
                Text("Dismiss")
            }
        },
        text = {
        }
    )
}
