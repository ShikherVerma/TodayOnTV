package com.shikherverma.todayontv.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.shikherverma.todayontv.data.DataManager
import io.reactivex.disposables.CompositeDisposable

/** Abstracts common features of all activities. All activities extend from this class. */
abstract class BaseActivity : AppCompatActivity() {
    lateinit var dataManager: DataManager
    lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        compositeDisposable = CompositeDisposable()
        dataManager = DataManager.getInstance(this)
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }
}
