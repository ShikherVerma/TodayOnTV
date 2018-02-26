package com.shikherverma.todayontv.view.activities

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shikherverma.todayontv.R
import com.shikherverma.todayontv.model.Episode
import com.shikherverma.todayontv.utils.UiUtils
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
        refresh_layout.setColorSchemeColors(ContextCompat.getColor(this, R.color.colorPrimary))
        refresh_layout.setOnRefreshListener({ loadSchedule() })
        loadSchedule()
    }

    private fun loadSchedule() {
        compositeDisposable.add(
                dataManager
                        .getTodaysSchedule()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(
                                object : DisposableSingleObserver<ArrayList<Episode>>() {
                                    override fun onSuccess(response: ArrayList<Episode>) {
                                        refresh_layout.isRefreshing = false
                                        list.adapter = EpisodesAdapter(response)
                                        switchUiState(UiState.SHOW_SCHEDULE)
                                    }

                                    override fun onError(t: Throwable) {
                                        val errorMsg = t.message
                                                ?: getString(R.string.windows10_error_message)
                                        if (refresh_layout.isRefreshing) {
                                            refresh_layout.isRefreshing = false
                                            Snackbar.make(root_view, errorMsg, Snackbar.LENGTH_LONG)
                                        } else {
                                            error_msg.text = errorMsg
                                            retry_button.setOnClickListener({ loadSchedule() })
                                            switchUiState(UiState.SHOW_ERROR)
                                        }
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

    /** Encapsulate switching UI state of lower half of screen  */
    private fun switchUiState(show: UiState) {
        when (show) {
            UiState.SHOW_SCHEDULE -> UiUtils.fadeSwitch(this, schedule_container, error_container, progress_container)
            UiState.SHOW_LOADING -> UiUtils.fadeSwitch(this, progress_container, schedule_container, error_container)
            UiState.SHOW_ERROR -> UiUtils.fadeSwitch(this, error_container, schedule_container, progress_container)
        }
    }

    /** represent UI state of screen  */
    private enum class UiState {
        SHOW_LOADING,
        SHOW_SCHEDULE,
        SHOW_ERROR
    }
}
