package com.example.caloru

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface ConsumableDao {
    @Query("SELECT * FROM Consumable")
    suspend fun getAll(): List<Consumable>

    @Insert
    suspend fun insert(consumable: Consumable)

    @Query("DELETE FROM Consumable WHERE id = :id")
    suspend fun deleteById(id: Int)
}
