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
import com.example.caloru.model.ConsumableAndConsumed

@Composable
fun ConsumableCard(cc: ConsumableAndConsumed) {
    fun getPortionText(cc: ConsumableAndConsumed): String {
        if (cc.consumed.usePortion) {
            return "${cc.consumed.amount}x portion (${cc.consumable.portion}g)"
        }
        return "${cc.consumed.amount}g";
    }

    Row {
        Column {
            Text(cc.consumable.name)
            Text(getPortionText(cc))
            Row {
                Text("${cc.consumable.calories} kcal")
                Spacer(Modifier.Companion.width(8.dp))
                Text(cc.consumable.proteins.toString())
                Spacer(Modifier.Companion.width(8.dp))
                Text(cc.consumable.fats.toString())
                Spacer(Modifier.Companion.width(8.dp))
                Text(cc.consumable.carbs.toString())
            }
        }
        Spacer(modifier = Modifier.Companion.weight(1f))
        Icon(
            painter = painterResource(R.drawable.delete_24dp_1f1f1f_fill0_wght400_grad0_opsz24),
            contentDescription = "delete"
        )
    }
}
