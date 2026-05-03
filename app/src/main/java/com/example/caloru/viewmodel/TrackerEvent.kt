package com.example.caloru.viewmodel

import com.example.caloru.model.Consumable
import com.example.caloru.model.TrackedItem

sealed interface TrackerEvent {
    object SaveConsumable : TrackerEvent
//    data class SetConsumableName(val name: String) : TrackerEvent
//    data class SetConsumablePortion(val portion: Int) : TrackerEvent
//    data class SetConsumableCalories(val calories: Int) : TrackerEvent
//    data class SetConsumableProteins(val proteins: Double) : TrackerEvent
//    data class SetConsumableFats(val fats: Double) : TrackerEvent
//    data class SetConsumableCarbs(val carbs: Double) : TrackerEvent
//    data class SetConsumableIsDish(val isDish: Boolean) : TrackerEvent
    object ShowAddConsumableDialog : TrackerEvent
    object HideAddConsumableDialog : TrackerEvent
//    data class DeleteConsumable(val consumable: Consumable) : TrackerEvent
//
//    object SaveTrackedItem : TrackerEvent
//    data class SetTrackedItemConsumableId(val id: Int) : TrackerEvent
//    data class SetTrackedItemMeal(val meal: String) : TrackerEvent
//    data class SetTrackedItemDate(val date: Long) : TrackerEvent
//    data class SetTrackedItemAmount(val amount: Float) : TrackerEvent
//    data class SetTrackedItemUsePortion(val usePortion: Boolean) : TrackerEvent
//    object ShowAddTrackedItemDialog : TrackerEvent
//    object HideAddTrackedItemDialog : TrackerEvent
//    data class DeleteTrackedItem(val trackedItem: TrackedItem) : TrackerEvent
//
//    data class SetSearchTerm(val searchTerm: String) : TrackerEvent
//    object ToggleIsSearching : TrackerEvent
}
