package com.example.caloru.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Consumable(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val portion: Int,
    val calories: Int,
    val proteins: Double,
    val fats: Double,
    val carbs: Double,
    val isDish: Boolean
)
