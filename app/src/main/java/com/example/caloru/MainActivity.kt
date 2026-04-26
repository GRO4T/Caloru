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
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
fun Product(
    name: String,
    portion: String,
    calories: Int,
    proteins: Double,
    fats: Double,
    carbs: Double,
    modifier: Modifier = Modifier
) {
    Row {
        Column {
            Text(name)
            Text(portion)
            Row {
                Text("$calories kcal")
                Spacer(Modifier.width(8.dp))
                Text(proteins.toString())
                Spacer(Modifier.width(8.dp))
                Text(fats.toString())
                Spacer(Modifier.width(8.dp))
                Text(carbs.toString())
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = { println("delete") }) {
            Text("x")
        }
    }
}

@Composable
fun Meal(name: String, modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    var isExpanded by rememberSaveable { mutableStateOf(true) }

    Column(modifier = modifier.padding(16.dp)) {
        Row {
            Text(name)
            Button(onClick = { isExpanded = !isExpanded }) {
                Text("v")
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = { println("add") }) {
                Text("+")
            }
        }
        AnimatedVisibility(visible = isExpanded) {
            content()
        }
    }
}

@Composable
fun Caloru() {
    Scaffold(modifier = Modifier.fillMaxSize().padding(vertical = 24.dp)) { innerPadding ->
        Column {
            Meal("Breakfast") {
                Product("Makaron z hummusem", "0.5x portion (350g)", 638, 22.6, 14.5, 102.0)
            }
            Meal("Breakfast II") {
            }
            Meal("Dinner") {
            }
            Meal("Supper") {
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
