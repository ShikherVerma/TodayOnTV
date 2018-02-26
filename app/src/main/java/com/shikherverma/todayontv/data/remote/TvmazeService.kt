package com.shikherverma.todayontv.data.remote

import com.shikherverma.todayontv.model.Episode
import io.reactivex.Single
import retrofit2.http.GET

/** Retrofit Service for consuming TV Maze API */
interface TvmazeService {
    @GET("schedule")
    fun getTodaysSchedule(): Single<ArrayList<Episode>>
}
