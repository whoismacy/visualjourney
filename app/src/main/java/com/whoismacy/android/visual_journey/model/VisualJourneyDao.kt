package com.whoismacy.android.visual_journey.model

import androidx.room.Dao
import androidx.room.Query

@Dao
interface VisualJourneyDao {
    @Query("INSERT INTO `habit` (`habit_name`, `full_habit_name`) VALUES (:habitName, :fullHabitName);")
    suspend fun createHabit(
        habitName: String,
        fullHabitName: String,
    )
        /*
        Creates a new Habit
         */

    @Query("SELECT `id` FROM `habit` WHERE `habit_name` = :habitName;")
    suspend fun getHabitId(habitName: String): Int
        /*
        Gets the habit Id
         */

    @Query("DELETE FROM `habit` WHERE `id` = :habitId;")
    suspend fun deleteHabit(habitId: Int)
        /*
        Drops a Habit from habit table
         */

    @Query("INSERT INTO `habits` (`habit_id`, `date`, `complete`) VALUES (:habitId, :status)")
    suspend fun markHabitComplete(
        habitId: String,
        status: Boolean,
    )
        /*
        Insert into Habits once a habit has been marked complete
         */
}
