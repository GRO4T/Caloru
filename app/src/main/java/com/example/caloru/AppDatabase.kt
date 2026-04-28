package com.example.caloru

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Consumable::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun consumableDao(): ConsumableDao
}
