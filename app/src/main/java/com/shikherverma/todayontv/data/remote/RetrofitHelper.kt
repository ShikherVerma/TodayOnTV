package com.shikherverma.todayontv.data.remote

import android.app.Application
import com.google.gson.Gson
import com.shikherverma.todayontv.BuildConfig
import com.shikherverma.todayontv.utils.Constants
import com.shikherverma.todayontv.utils.NetworkUtils
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/** Helper class for initializing Retrofit  */
class RetrofitHelper private constructor(application: Application) {
    private val retrofit: Retrofit

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder
                .addInterceptor(interceptor)
                .retryOnConnectionFailure(true)
                .cache(Cache(application.cacheDir, (10 * 1024 * 1024).toLong())) // 10 MB
                .addInterceptor { chain ->
                    var request = chain.request()
                    request = if (NetworkUtils.isNetworkAvailable(application)) {
                        request
                                .newBuilder()
                                .header("Cache-Control", "public, max-age=" + 60) // 1 minute
                                .build()
                    } else {
                        request
                                .newBuilder()
                                .header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24) // 1 day
                                .build()
                    }
                    chain.proceed(request)
                }
                .build()

        val okHttpClient = okHttpClientBuilder.build()
        retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Constants.ENDPOINT)
                .client(okHttpClient)
                .build()
    }

    fun newTvmazeService(): TvmazeService {
        return retrofit.create<TvmazeService>(TvmazeService::class.java)
    }

    companion object {
        @Volatile
        private var instance: RetrofitHelper? = null

        fun getInstance(application: Application): RetrofitHelper {
            return instance ?: RetrofitHelper(application).also { instance = it }
        }
    }
}
