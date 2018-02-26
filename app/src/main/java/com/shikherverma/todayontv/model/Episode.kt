package com.shikherverma.todayontv.model

import java.util.*

/** Server response model for a single episode */
data class Episode(
        val id: Int,
        val name: String,
        val season: Int,
        val number: Int,
        val airstamp: Date,
        val runtime: Int,
        val image: ImageInfo?,
        val summary: String?,
        val show: Show
)
