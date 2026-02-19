package com.whoismacy.android.visual_journey.model

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Habits::class, Habit::class], version = 1)
@TypeConverters(VisualJourneyConverter::class)
abstract class HabitDatabase : RoomDatabase() {
    abstract fun visualJourneyDao(): VisualJourneyDao
}
