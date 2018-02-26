package com.shikherverma.todayontv.view.activities

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shikherverma.todayontv.R
import com.shikherverma.todayontv.model.Episode
import com.shikherverma.todayontv.utils.UiUtils.setHtmlToTextView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_schedule.*
import kotlinx.android.synthetic.main.inflate_episode.view.*

/**
 * Shows episodes in chronological order
 */
class ScheduleActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)
        val listAdapter = EpisodesAdapter(ArrayList())
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = listAdapter
        compositeDisposable.add(
                dataManager
                        .getTodaysSchedule()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(
                                object : DisposableSingleObserver<ArrayList<Episode>>() {
                                    override fun onSuccess(response: ArrayList<Episode>) {
                                        list.adapter = EpisodesAdapter(response)
                                    }

                                    override fun onError(t: Throwable) {
                                        TODO("Show error state, add the three state UI")
                                    }
                                }))
    }

    class EpisodesAdapter(private val items: List<Episode>) : RecyclerView.Adapter<ViewHolder>() {

        private fun ViewGroup.inflate(layoutRes: Int) = LayoutInflater.from(context).inflate(layoutRes, this, false)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent.inflate(R.layout.inflate_episode))

        override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

        override fun getItemCount(): Int = items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Episode) {
            itemView.author.text = item.name
            setHtmlToTextView(itemView.content, item.summary)
        }
    }
}
