package com.shikherverma.todayontv.view.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.shikherverma.todayontv.R
import com.shikherverma.todayontv.databinding.InflateEpisodeBinding
import com.shikherverma.todayontv.model.Episode
import com.shikherverma.todayontv.viewmodel.EpisodeViewModel

class EpisodesAdapter(episodes: List<Episode>) : RecyclerView.Adapter<EpisodesAdapter.EpisodeBindingHolder>() {

    private val episodeViewModels: List<EpisodeViewModel> = episodes.map { it -> EpisodeViewModel(it) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = EpisodeBindingHolder(
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.inflate_episode, parent, false))

    override fun onBindViewHolder(holder: EpisodeBindingHolder, position: Int) {
        holder.binding.viewModel = episodeViewModels[position]
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int = episodeViewModels.size

    class EpisodeBindingHolder(var binding: InflateEpisodeBinding) : RecyclerView.ViewHolder(binding.card)

}