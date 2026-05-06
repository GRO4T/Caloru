package com.example.caloru.viewmodel

sealed interface TrackerEvent {
    object SaveConsumable : TrackerEvent

    //    data class SetConsumableName(val name: String) : TrackerEvent
//    data class SetConsumablePortion(val portion: Int) : TrackerEvent
//    data class SetConsumableCalories(val calories: Int) : TrackerEvent
//    data class SetConsumableProteins(val proteins: Double) : TrackerEvent
//    data class SetConsumableFats(val fats: Double) : TrackerEvent
//    data class SetConsumableCarbs(val carbs: Double) : TrackerEvent
//    data class SetConsumableIsDish(val isDish: Boolean) : TrackerEvent
    data class ShowAddConsumableDialog(val isDish: Boolean) : TrackerEvent
    object HideAddConsumableDialog : TrackerEvent

    //    data class DeleteConsumable(val consumable: Consumable) : TrackerEvent
//
    object SaveTrackedItem : TrackerEvent

    //    data class SetTrackedItemConsumableId(val id: Int) : TrackerEvent
//    data class SetTrackedItemAmount(val amount: Float) : TrackerEvent
//    data class SetTrackedItemUsePortion(val usePortion: Boolean) : TrackerEvent
    data class ShowAddTrackedItemDialog(val mealName: String) : TrackerEvent
    object HideAddTrackedItemDialog : TrackerEvent

    //    data class DeleteTrackedItem(val trackedItem: TrackedItem) : TrackerEvent
//
    data class SetSearchTerm(val searchTerm: String) : TrackerEvent
}
