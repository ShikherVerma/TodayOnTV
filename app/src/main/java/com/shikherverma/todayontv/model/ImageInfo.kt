package com.shikherverma.todayontv.model

import java.io.Serializable

/** Server response model for image information */
data class ImageInfo(
        val medium: String,
        val original: String
) : Serializable
