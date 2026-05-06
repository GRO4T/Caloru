package com.example.caloru

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.caloru.model.Consumable
import com.example.caloru.model.TrackedItem
import com.example.caloru.model.LocalDatabase
import com.example.caloru.model.TrackedItemConsumable
import com.example.caloru.ui.theme.CaloruTheme
import com.example.caloru.view.TrackerScreen
import com.example.caloru.view.AddTrackedItemScreen
import com.example.caloru.viewmodel.TrackerViewModel


@Suppress("UNCHECKED_CAST")
class MainActivity : ComponentActivity() {
    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            LocalDatabase::class.java,
            "caloru.db"
        ).build()
    }

    private val viewModel by viewModels<TrackerViewModel> (
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return TrackerViewModel(db.consumableDao, db.trackedItemDao, db.trackedItemConsumableDao) as T
                }
            }
        }
    )

    private val consumables = listOf(
        TrackedItemConsumable(
            consumable = Consumable(1, "Makaron z hummusem", 350, 638, 22.6, 14.5, 102.0, true),
            trackedItem = TrackedItem(1, 1, "Breakfast", 123, 0.5f, true)
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaloruTheme {
                // val state: TrackerState = TrackerState(consumables)
                val state by viewModel.state.collectAsState()
                if (state.isAddingTrackedItem) {
                    AddTrackedItemScreen(state = state, onEvent = viewModel::onEvent)
                } else {
                    TrackerScreen(state = state, onEvent = viewModel::onEvent)
                }
            }
        }
    }
}
