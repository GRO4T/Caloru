package com.example.caloru.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ConsumableDao {
    @Query("SELECT * FROM Consumable")
    suspend fun getAll(): List<Consumable>

    @Query("SELECT * FROM Consumable WHERE name LIKE '%' + :pattern + '%'")
    suspend fun searchAllByName(pattern: String): List<Consumable>

    @Insert
    suspend fun insert(consumable: Consumable)

    @Query("DELETE FROM Consumable WHERE id = :id")
    suspend fun deleteById(id: Int)
}
