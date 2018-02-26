package com.shikherverma.todayontv.model

import java.io.Serializable

/**
 * Server response model for the Network on which Show is airing
 */
data class ShowNetwork(val id: Int, val name: String) : Serializable
