package com.whoismacy.android.visual_journey.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Habits(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo("habit_id") val habitId: Int,
    @ColumnInfo("date") val date: Date,
    @ColumnInfo("complete", defaultValue = "0") val habitComplete: Boolean,
)

@Entity
data class Habit(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo("habit_name") val name: String,
    @ColumnInfo("created_on") val created: Date,
)
