package com.shikherverma.todayontv.utils

import android.content.Context
import android.net.ConnectivityManager

/** A non-instantiable class containing static function for Network and Url logic. */
class NetworkUtils private constructor() {

    companion object {
        fun isNetworkAvailable(context: Context): Boolean {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return connectivityManager.activeNetworkInfo != null
        }
    }
}
