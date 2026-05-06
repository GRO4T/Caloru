package com.example.caloru.viewmodel

import androidx.lifecycle.ViewModel
import com.example.caloru.model.ConsumableDao
import com.example.caloru.model.TrackedItemConsumableDao
import com.example.caloru.model.TrackedItemDao
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*

@OptIn(ExperimentalCoroutinesApi::class)
class TrackerViewModel(
    private val consumableDao: ConsumableDao,
    private val trackedItemDao: TrackedItemDao,
    private val trackedItemConsumableDao: TrackedItemConsumableDao
): ViewModel() {
    private val _state = MutableStateFlow(TrackerState())
    val state: StateFlow<TrackerState> = _state.asStateFlow()

    fun onEvent(event: TrackerEvent) {
        when(event) {
            TrackerEvent.SaveConsumable -> {
                // TODO
            }
            is TrackerEvent.ShowAddConsumableDialog -> {
                _state.update {it.copy(
                    isAddingConsumable = true,
                    consumableIsDish = event.isDish,
                )}
            }
            TrackerEvent.HideAddConsumableDialog -> {
                _state.update {it.copy(
                    isAddingConsumable = false,
                )}
            }
            TrackerEvent.SaveTrackedItem -> {
                // TODO
            }
            is TrackerEvent.ShowAddTrackedItemDialog -> {
                _state.update {it.copy(
                    isAddingTrackedItem = true,
                    trackedItemMeal = event.mealName
                )}
            }
            TrackerEvent.HideAddTrackedItemDialog -> {
                _state.update {it.copy(
                    isAddingTrackedItem = false,
                )}
            }
            is TrackerEvent.SetSearchTerm -> {
                _state.update {it.copy(
                    searchTerm = event.searchTerm
                )}
            }
        }
    }
}
