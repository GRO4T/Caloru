package com.example.caloru.viewmodel

import com.example.caloru.model.Consumable
import com.example.caloru.model.TrackedItemConsumable

data class TrackerState(
    val trackedItemConsumables: List<TrackedItemConsumable> = emptyList(),

    val searchTerm: String = "",
    var consumables: List<Consumable> = emptyList(),

    val isAddingConsumable: Boolean = false,
    val consumableName: String = "",
    val consumablePortion: Int = 0,
    val consumableCalories: Int = 0,
    val consumableProteins: Double = 0.0,
    val consumableFats: Double = 0.0,
    val consumableCarbs: Double = 0.0,
    val consumableIsDish: Boolean = false,

    val isAddingTrackedItem: Boolean = false,
    val trackedItemConsumableId: Int = 0,
    val trackedItemMeal: String = "",
    val trackedItemDate: Long = 0,
    val trackedItemAmount: Float = 0.0f,
    val trackedItemUsePortion: Boolean = false
)
