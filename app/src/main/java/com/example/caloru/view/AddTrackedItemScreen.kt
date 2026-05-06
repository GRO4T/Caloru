package com.example.caloru.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.caloru.R
import com.example.caloru.viewmodel.TrackerEvent
import com.example.caloru.viewmodel.TrackerState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTrackedItemScreen(
    state: TrackerState,
    onEvent: (TrackerEvent) -> Unit,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        state.trackedItemMeal,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        onEvent(TrackerEvent.HideAddTrackedItemDialog)
                    }) {
                        Icon(
                            painter = painterResource(R.drawable.arrow_back_24dp_1f1f1f_fill0_wght400_grad0_opsz24),
                            contentDescription = "arrow_back"
                        )
                    }
                }
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = { onEvent(TrackerEvent.ShowAddConsumableDialog(false)) },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("New Product")
                }

                Button(
                    onClick = { onEvent(TrackerEvent.ShowAddConsumableDialog(true)) },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("New Dish")
                }
            }
        }
    ) { padding ->
        if (state.isAddingConsumable) {
            AddConsumableDialog(state = state, onEvent = onEvent)
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
        ) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.searchTerm,
                onValueChange = {
                    onEvent(TrackerEvent.SetSearchTerm(it))
                },
                placeholder = {
                    Text(text = "Search consumable")
                }
            )
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(items = state.consumables, itemContent = { consumable ->
                    ConsumableCard(consumable = consumable, onEvent = onEvent)
                })
            }
        }
    }
}
