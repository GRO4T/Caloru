package com.example.caloru

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.caloru.model.Consumable
import com.example.caloru.model.ConsumableDao

@Database(entities = [Consumable::class], version = 1)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun consumableDao(): ConsumableDao
}
