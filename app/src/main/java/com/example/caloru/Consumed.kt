package com.example.caloru

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Consumed(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val consumableId: Int,
    val meal: String,
    val date: Long,
    val amount: Float,
    val usePortion: Boolean
)
