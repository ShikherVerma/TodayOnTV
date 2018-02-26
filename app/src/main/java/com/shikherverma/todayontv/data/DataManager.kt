package com.shikherverma.todayontv.data

import android.app.Application
import android.content.Context
import com.shikherverma.todayontv.data.remote.RetrofitHelper
import com.shikherverma.todayontv.data.remote.TvmazeService
import com.shikherverma.todayontv.model.Episode
import io.reactivex.Single

/**
 * Singleton for managing data access
 * */
class DataManager private constructor(application: Application) {

    private var tvmazeServiceService: TvmazeService = RetrofitHelper.getInstance(application).newTvmazeService()

    companion object {
        @Volatile
        private lateinit var instance: DataManager

        fun buildInstance(application: Application): DataManager {
            instance = DataManager(application)
            return instance
        }

        fun getInstance(context: Context): DataManager = instance
    }

    fun getTodaysSchedule(): Single<ArrayList<Episode>> = tvmazeServiceService.getTodaysSchedule()
}
