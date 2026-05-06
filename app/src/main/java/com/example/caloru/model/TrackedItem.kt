package com.example.caloru.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TrackedItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val consumableId: Int,
    val meal: String,
    val date: Long,
    val amount: Float,
    val usePortion: Boolean
)
