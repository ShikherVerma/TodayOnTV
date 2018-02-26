package com.shikherverma.todayontv.model

import com.google.gson.annotations.JsonAdapter
import com.shikherverma.todayontv.data.remote.DaysOfWeekDeserializer
import java.io.Serializable
import java.util.*

/**
 * Server response model for Show airing days and timing
 */
data class ShowSchedule(
        val time: String,
        @JsonAdapter(DaysOfWeekDeserializer::class)
        val days: EnumSet<DayOfWeek>
)  : Serializable
