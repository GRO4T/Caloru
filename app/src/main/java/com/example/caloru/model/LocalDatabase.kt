package com.example.caloru.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        Consumable::class,
        TrackedItem::class,
    ],
    version = 1
)
abstract class LocalDatabase : RoomDatabase() {
    abstract val consumableDao: ConsumableDao
    abstract val trackedItemDao: TrackedItemDao
    abstract val trackedItemConsumableDao: TrackedItemConsumableDao
}
