package com.shikherverma.todayontv

import android.app.Application
import com.shikherverma.todayontv.data.DataManager

class CustomApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        DataManager.buildInstance(this)
    }
}
