package com.example.caloru.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.caloru.R
import com.example.caloru.model.TrackedItemConsumable

@Composable
fun TrackedItemCard(tc: TrackedItemConsumable) {
    fun getPortionText(tc: TrackedItemConsumable): String {
        if (tc.trackedItem.usePortion) {
            return "${tc.trackedItem.amount}x portion (${tc.consumable.portion}g)"
        }
        return "${tc.trackedItem.amount}g";
    }

    Row {
        Column {
            Text(tc.consumable.name)
            Text(getPortionText(tc))
            Row {
                Text("${tc.consumable.calories} kcal")
                Spacer(Modifier.width(8.dp))
                Text(tc.consumable.proteins.toString())
                Spacer(Modifier.width(8.dp))
                Text(tc.consumable.fats.toString())
                Spacer(Modifier.width(8.dp))
                Text(tc.consumable.carbs.toString())
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(R.drawable.delete_24dp_1f1f1f_fill0_wght400_grad0_opsz24),
            contentDescription = "delete"
        )
    }
}
