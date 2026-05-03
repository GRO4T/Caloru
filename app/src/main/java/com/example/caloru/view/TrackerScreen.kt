package com.example.caloru.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.room.Room
import com.example.caloru.model.LocalDatabase
import com.example.caloru.viewmodel.TrackerEvent
import com.example.caloru.viewmodel.TrackerState
import com.example.caloru.viewmodel.TrackerViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaloruScreen(
    state: TrackerState,
    onEvent: (TrackerEvent) -> Unit,
) {
    val meals = listOf("Breakfast", "Breakfast II", "Dinner", "Supper")

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "Caloru",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
            )
        },
        bottomBar = {
            Text(
                text = "Kcal 1034 Prot 34 Fats 47 Carbs 121",
                modifier = Modifier.fillMaxWidth().padding(bottom=16.dp),
                textAlign = TextAlign.Center
            )
        }
    ) { padding ->
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(items = meals, itemContent = { mealName ->

                MealCard(
                    name = mealName,
                    trackedItemConsumables = state.trackedItemConsumables.filter { it.trackedItem.meal == mealName },
                    onEvent = onEvent
                )
            })
        }
    }
}
