package com.shikherverma.todayontv.utils

/**
 * A non-instantiable class containing static final CONSTANTS <br>
 * File contains : <br>
 * All non-ui strings constants that won't be visible to user <br>
 * All constants that assume something about api <br>
 * All constants that belong to the project rather than the class should be here.<br>
 */
class Constants private constructor() {
    companion object {
        const val ENDPOINT = "http://api.tvmaze.com/"
    }
}
