package com.whoismacy.android.visual_journey.model

import android.content.Context
import androidx.room.Room

private const val DATABASE_NAME = "habit-db"

class HabitRepository private constructor(
    context: Context,
) {
    private val database: HabitDatabase =
        Room
            .databaseBuilder(
                context.applicationContext,
                HabitDatabase::class.java,
                DATABASE_NAME,
            ).build()

    private val visualJourneyDao = database.visualJourneyDao()

    suspend fun createHabit(
        habitName: String,
        fullHabitName: String,
    ) {
        visualJourneyDao.createHabit(habitName, fullHabitName)
    }

    suspend fun getHabitId(habitName: String) {
        visualJourneyDao.getHabitId(habitName)
    }

    suspend fun deleteHabit(habitId: Int) {
        visualJourneyDao.deleteHabit(habitId)
    }

    suspend fun markHabitComplete(
        habitId: String,
        status: Boolean,
    ) {
        visualJourneyDao.markHabitComplete(habitId, status)
    }

    companion object {
        @Suppress("ktlint:standard:property-naming")
        private var INSTANCE: HabitRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = HabitRepository(context)
            }
        }

        fun get(): HabitRepository =
            INSTANCE
                ?: throw IllegalStateException("CrimeRepository must be initialized")
    }
}
