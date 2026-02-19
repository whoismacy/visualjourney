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

    companion object {
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
