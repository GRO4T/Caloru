package com.example.caloru.model

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface TrackedItemDao {
    @Upsert
    suspend fun upsert(trackedItem: TrackedItem)

    @Query("DELETE FROM TrackedItem WHERE id = :id")
    suspend fun deleteById(id: Int)
}
