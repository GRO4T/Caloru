package com.example.caloru.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caloru.model.Consumable
import com.example.caloru.model.ConsumableAndConsumed
import com.example.caloru.model.Consumed

@Composable
fun CaloruScreen() {
    // Mocked data as if it came from the database
    val consumables = listOf(
        ConsumableAndConsumed(
            consumable = Consumable(1, "Makaron z hummusem", 350, 638, 22.6, 14.5, 102.0),
            consumed = Consumed(1, 1, "Breakfast", 123, 0.5f, true)
        )
    )

    Scaffold(
        modifier = Modifier.Companion
            .fillMaxSize()
            .padding(vertical = 24.dp)
    ) { innerPadding ->
        Column(modifier = Modifier.Companion.padding(innerPadding)) {
            val meals = listOf("Breakfast", "Breakfast II", "Dinner", "Supper")

            meals.forEach { mealName ->
                MealCard(
                    name = mealName,
                    consumables = consumables.filter { it.consumed.meal == mealName }
                )
            }

            Spacer(modifier = Modifier.Companion.weight(1f))
            Text("Kcal 1034 Prot 34 Fats 47 Carbs 121")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CaloruScreenPreview() {
    CaloruScreen()
}
