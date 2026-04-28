package com.example.caloru

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caloru.ui.theme.CaloruTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaloruTheme {
                Caloru()
            }
        }
    }
}

@Composable
fun ConsumableCard(
    cc: ConsumableAndConsumed,
    modifier: Modifier = Modifier
) {
    fun getPortionText(cc: ConsumableAndConsumed): String {
        if (!cc.consumed.usePortion) {
            return cc.consumed.amount.toString() + "g"
        }
        return cc.consumed.amount.toString() + "x portion (" + cc.consumable.portion.toString() + "g)"
    }

    Row(modifier = modifier) {
        Column {
            Text(cc.consumable.name)
            Text(getPortionText(cc))
            Row {
                Text("${cc.consumable.calories} kcal")
                Spacer(Modifier.width(8.dp))
                Text(cc.consumable.proteins.toString())
                Spacer(Modifier.width(8.dp))
                Text(cc.consumable.fats.toString())
                Spacer(Modifier.width(8.dp))
                Text(cc.consumable.carbs.toString())
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = { println("delete ${cc.consumable.id}") }) {
            Text("x")
        }
    }
}

@Composable
fun MealCard(
    name: String,
    consumables: List<ConsumableAndConsumed>,
    modifier: Modifier = Modifier
) {
    var isExpanded by rememberSaveable { mutableStateOf(true) }

    Column(modifier = modifier.padding(16.dp)) {
        Row {
            Text(name)
            Button(onClick = { isExpanded = !isExpanded }) {
                Text("v")
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = { println("add to $name") }) {
                Text("+")
            }
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

@Composable
fun Caloru() {
    // Mocked data as if it came from the database
    val consumables = listOf(
        ConsumableAndConsumed(
            consumable = Consumable(1, "Makaron z hummusem", 350, 638, 22.6, 14.5, 102.0),
            consumed = Consumed(1, 1, "Breakfast", 123, 0.5f, true)
        )
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 24.dp)
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            val meals = listOf("Breakfast", "Breakfast II", "Dinner", "Supper")

            meals.forEach { mealName ->
                MealCard(
                    name = mealName,
                    consumables = consumables.filter { it.consumed.meal == mealName }
                )
            }

            Spacer(modifier = Modifier.weight(1f))
            Text("Kcal 1034 Prot 34 Fats 47 Carbs 121")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CaloruPreview() {
    Caloru()
}
