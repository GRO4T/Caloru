package com.example.caloru.model

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface ConsumableAndConsumedDao {
    @Transaction
    @Query("SELECT * FROM Consumed WHERE Consumed.meal = :meal")
    suspend fun getAllConsumablesAndConsumedByMeal(meal: String): List<ConsumableAndConsumed>
}
