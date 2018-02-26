package com.shikherverma.todayontv.model

import java.util.*

/**
 * Represents a day of week
 * Custom implementation because java.time.DayOfWeek only available above API 26
 * */
enum class DayOfWeek(val dayNumber: Int) {
    MONDAY(1) {
        override fun toString(): String = "Monday"
    },
    TUESDAY(2) {
        override fun toString(): String = "Tuesday"
    },
    WEDNESDAY(3) {
        override fun toString(): String = "Wednesday"
    },
    THURSDAY(4) {
        override fun toString(): String = "Thursday"
    },
    FRIDAY(5) {
        override fun toString(): String = "Friday"
    },
    SATURDAY(6) {
        override fun toString(): String = "Saturday"
    },
    SUNDAY(7) {
        override fun toString(): String = "Sunday"
    };

    companion object {
        fun parse(dayName: String): DayOfWeek {
            for (dayOfWeek in enumValues<DayOfWeek>())
                if (dayOfWeek.toString() == dayName) return dayOfWeek
            throw InputMismatchException("Day of week can only be one of " +
                    enumValues<DayOfWeek>().joinToString(", ", "[ ", "]"))
        }
    }
}
