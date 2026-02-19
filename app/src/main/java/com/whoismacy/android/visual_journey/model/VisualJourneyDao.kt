package com.whoismacy.android.visual_journey.model

import androidx.room.Dao
import androidx.room.Query

@Dao
interface VisualJourneyDao {
    @Query("INSERT INTO `habit` (`habit_name`) VALUES (:habitName);")
    suspend fun createHabit(habitName: String) {
        /*
        Creates a new Habit
         */
    }

    @Query("SELECT `id` FROM `habit` WHERE `habit_name` = ':habitName';")
    suspend fun getHabitId(habitName: String) {
        /*
        Gets the habit Id before moving on
         */
    }

    @Query("DELETE FROM `habit` WHERE `id` = :habitId;")
    suspend fun deleteHabit(habitId: Int) {
        /*
        Drops a Habit from habit table
         */
    }

    @Query("INSERT INTO `habits` (`habit_id`, `date`, `complete`) VALUES ()")
    suspend fun markHabitComplete(
        habitId: String,
        status: Boolean,
    ) {
        /*
        Insert into Habits once a habit has been marked complete
         */
    }
}
