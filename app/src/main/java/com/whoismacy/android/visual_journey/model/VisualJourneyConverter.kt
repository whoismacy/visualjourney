package com.whoismacy.android.visual_journey.model

import androidx.room.TypeConverter
import java.util.Date

class VisualJourneyConverter {
    @TypeConverter
    fun fromLongToDate(time: Long?): Date? =
        time?.let {
            Date(it)
        }

    @TypeConverter
    fun fromDateToLong(time: Date?): Long? = time?.time
}
