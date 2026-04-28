package com.example.caloru

import androidx.room.Embedded
import androidx.room.Relation

data class ConsumableAndConsumed(
    @Embedded
    val consumable: Consumable,
    @Relation(
        parentColumn = "id",
        entityColumn = "consumableId"
    )
    val consumed: Consumed
)
