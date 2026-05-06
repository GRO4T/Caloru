package com.example.caloru.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.caloru.model.Consumable
import com.example.caloru.viewmodel.TrackerEvent

@Composable
fun ConsumableCard(
    consumable: Consumable,
    onEvent: (TrackerEvent) -> Unit
) {
    Column {
        Text(consumable.name)
        Text(consumable.portion.toString())
        Text(consumable.calories.toString())
    }
}
