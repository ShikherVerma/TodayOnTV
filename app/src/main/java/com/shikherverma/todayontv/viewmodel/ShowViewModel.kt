package com.shikherverma.todayontv.viewmodel

import android.databinding.BaseObservable
import android.databinding.BindingAdapter
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.shikherverma.todayontv.R
import com.shikherverma.todayontv.model.Show

class ShowViewModel(val show: Show) : BaseObservable() {

    fun getGenresAsString(): String = show.genres.joinToString()

    fun getDaysOfWeekAsString(): String = show.schedule.days.joinToString { it -> it.toString() }

    fun onFabClick(view: View) = Snackbar.make(view, "TODO: Set reminder in calendar", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()

    companion object {

        @JvmStatic
        @BindingAdapter("setImage")
        fun setImage(imageView: ImageView, viewModel: ShowViewModel) {
            if (viewModel.show.image != null) {
                Glide.with(imageView.context)
                        .load(viewModel.show.image.original)
                        .apply(RequestOptions()
                                .placeholder(R.color.colorPrimary))
                        .into(imageView)
            }
        }
    }
}