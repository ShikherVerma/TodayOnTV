package com.shikherverma.todayontv.viewmodel

import android.content.Intent
import android.databinding.BaseObservable
import android.databinding.BindingAdapter
import android.support.v7.widget.CardView
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.shikherverma.todayontv.R
import com.shikherverma.todayontv.model.Episode
import com.shikherverma.todayontv.model.SHOW_TAG
import com.shikherverma.todayontv.view.activity.ShowActivity
import kotlinx.android.synthetic.main.inflate_episode.view.*

class EpisodeViewModel(val episode: Episode) : BaseObservable() {
    var isSelected: Boolean = false

    fun onAboutShowClick(view: View) {
        val intent = Intent(view.context, ShowActivity::class.java)
        intent.putExtra(SHOW_TAG, episode.show)
        view.context.startActivity(intent)
    }

    companion object {

        @JvmStatic
        @BindingAdapter("cardCustomElevation")
        fun setCardElevation(card: CardView, viewModel: EpisodeViewModel) {
            if (viewModel.isSelected) {
                card.cardElevation = card.context.resources.getDimension(R.dimen.card_selected_elevation)
            } else {
                card.cardElevation = card.context.resources.getDimension(R.dimen.card_elevation)
            }
        }

        @JvmStatic
        @BindingAdapter("setImage")
        fun setImage(imageView: ImageView, viewModel: EpisodeViewModel) {
            val src: String =
                    when {
                        viewModel.episode.image != null -> viewModel.episode.image.medium
                        viewModel.episode.show.image != null -> viewModel.episode.show.image.medium
                        else -> ""
                    }
            Glide.with(imageView.context)
                    .load(src)
                    .apply(RequestOptions()
                            .placeholder(R.drawable.ic_placeholder)
                            .error(R.drawable.ic_error))
                    .into(imageView)
        }

        @JvmStatic
        @BindingAdapter("onCardClick")
        fun onCardClick(card: CardView, viewModel: EpisodeViewModel) {
            card.setOnClickListener({
                viewModel.isSelected = !viewModel.isSelected
                if (viewModel.isSelected) {
                    card.cardElevation = card.context.resources.getDimension(R.dimen.card_selected_elevation)
                    card.details.visibility = View.VISIBLE
                } else {
                    card.cardElevation = card.context.resources.getDimension(R.dimen.card_elevation)
                    card.details.visibility = View.GONE
                }
            })
        }
    }
}
