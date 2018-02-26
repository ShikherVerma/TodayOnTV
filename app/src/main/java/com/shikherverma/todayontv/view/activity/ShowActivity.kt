package com.shikherverma.todayontv.view.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.shikherverma.todayontv.R
import com.shikherverma.todayontv.databinding.ActivityShowBinding
import com.shikherverma.todayontv.model.SHOW_TAG
import com.shikherverma.todayontv.model.Show
import com.shikherverma.todayontv.viewmodel.ShowViewModel
import kotlinx.android.synthetic.main.activity_show.*


class ShowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityShowBinding = DataBindingUtil.setContentView(this, R.layout.activity_show)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if (intent.extras != null) {
            val show: Show = intent.getSerializableExtra(SHOW_TAG) as Show
            binding.viewModel = ShowViewModel(show)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        super.onBackPressed()
        return true
    }

}
