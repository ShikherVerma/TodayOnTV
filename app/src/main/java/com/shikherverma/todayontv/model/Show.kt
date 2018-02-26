package com.shikherverma.todayontv.model

import java.util.*

/** Server response model for a show */
data class Show(
        val id: Int,
        val name: String,
        val type: String,
        val language: String,
        val genres: ArrayList<String>,
        val runtime: Int,
        val premiered: Date,
        val officialSite: String?,
        val schedule: ShowSchedule,
        val network: ShowNetwork,
        val image: ImageInfo?,
        val summary: String?
)
