package com.example.caloru.model

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface TrackedItemConsumableDao {
    @Transaction
    @Query("SELECT * FROM TrackedItem WHERE date = :date")
    suspend fun getAllConsumablesAndTrackedItemByDate(date: Long): List<TrackedItemConsumable>
}
