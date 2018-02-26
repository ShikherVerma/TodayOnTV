package com.shikherverma.todayontv

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_schedule.*
import kotlinx.android.synthetic.main.inflate_episode.view.*

class ScheduleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)
        val episode = Episode("Author Name", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.")
        val listAdapter = EpisodesAdapter(List(10) { _ -> episode })
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = listAdapter
    }

    data class Episode(val author: String, val content: String)

    class EpisodesAdapter(private val items: List<Episode>) : RecyclerView.Adapter<ViewHolder>() {

        private fun ViewGroup.inflate(layoutRes: Int) = LayoutInflater.from(context).inflate(layoutRes, this, false)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent.inflate(R.layout.inflate_episode))

        override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

        override fun getItemCount(): Int = items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Episode) {
            itemView.author.text = item.author
            itemView.content.text = item.content
        }
    }
}
