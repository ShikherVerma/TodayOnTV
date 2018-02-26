package com.shikherverma.todayontv.viewmodel

import android.databinding.BaseObservable
import android.databinding.BindingAdapter
import android.support.v7.widget.CardView
import android.view.View
import com.shikherverma.todayontv.R
import com.shikherverma.todayontv.model.Episode
import kotlinx.android.synthetic.main.inflate_episode.view.*

class EpisodeViewModel(val episode: Episode) : BaseObservable() {
    var isSelected: Boolean = false

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
