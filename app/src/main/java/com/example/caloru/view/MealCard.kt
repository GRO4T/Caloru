package com.example.caloru.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.caloru.R
import com.example.caloru.model.ConsumableAndConsumed

@Composable
fun MealCard(
    name: String,
    consumables: List<ConsumableAndConsumed>,
) {
    var isExpanded by rememberSaveable { mutableStateOf(true) }

    Column {
        Row {
            Text(name)
            Icon(
                painter = painterResource(R.drawable.arrow_drop_down_24dp_1f1f1f_fill0_wght400_grad0_opsz24),
                contentDescription = "dropdown"
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(R.drawable.add_24dp_1f1f1f_fill0_wght400_grad0_opsz24),
                contentDescription = "add"
            )
        }
        AnimatedVisibility(visible = isExpanded) {
            Column {
                consumables.forEach { consumable ->
                    ConsumableCard(consumable)
                }
            }
        }
    }
}
