package com.example.caloru.model

import androidx.room.Embedded
import androidx.room.Relation

data class TrackedItemConsumable(
    @Embedded
    val trackedItem: TrackedItem,
    @Relation(
        parentColumn = "consumableId",
        entityColumn = "id"
    )
    val consumable: Consumable
)
