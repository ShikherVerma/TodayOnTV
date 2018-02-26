package com.shikherverma.todayontv.utils

import android.content.Context
import android.net.ConnectivityManager

/** A singleton class containing function for Network and Url logic. */
object NetworkUtils {
    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.activeNetworkInfo != null
    }
}
