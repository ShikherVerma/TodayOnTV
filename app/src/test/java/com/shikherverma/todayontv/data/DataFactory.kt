package com.shikherverma.todayontv.data

import com.shikherverma.todayontv.model.*
import java.util.*
import kotlin.collections.ArrayList

/**
 * singleton class to provide fake data
 */
object DataFactory {

    fun parseListOfPosts(): List<Episode> {
        val episodes = ArrayList<Episode>()
        episodes.add(Episode(1404177,
                "February 25, 2018",
                2018,
                8,
                Date(1519567200.toLong() * 1000.toLong()), // Epoch in seconds * 1000 milliseconds
                60,
                null,
                null,
                Show(
                        8835,
                        "Meet the Press",
                        "News",
                        "English",
                        ArrayList(),
                        60,
                        Date((-699148800).toLong() * 1000.toLong()), // Epoch in seconds * 1000 milliseconds
                        "http://www.nbcnews.com/meet-the-press",
                        ShowSchedule("09:00", EnumSet.of(DayOfWeek.SUNDAY)),
                        ShowNetwork(1, "NBC"),
                        ImageInfo("http://static.tvmaze.com/uploads/images/medium_portrait/31/78377.jpg", "http://static.tvmaze.com/uploads/images/original_untouched/31/78377.jpg"),
                        "<p>For almost as long as there has been television, there's been <b>Meet the Press</b>. The hourlong Sunday morning public affairs program has featured interviews with countless U.S. and world leaders, and has reviewed, analyzed and discussed the news of the week -- all while looking toward the week ahead.</p>"
                )
        ))
        return episodes
    }

    const val jsonResponse = "[{\"id\":1404177,\"url\":\"http://www.tvmaze.com/episodes/1404177/meet-the-press-2018-02-25-february-25-2018\",\"name\":\"February 25, 2018\",\"season\":2018,\"number\":8,\"airdate\":\"2018-02-25\",\"airtime\":\"09:00\",\"airstamp\":\"2018-02-25T14:00:00+00:00\",\"runtime\":60,\"image\":null,\"summary\":null,\"show\":{\"id\":8835,\"url\":\"http://www.tvmaze.com/shows/8835/meet-the-press\",\"name\":\"Meet the Press\",\"type\":\"News\",\"language\":\"English\",\"genres\":[],\"status\":\"Running\",\"runtime\":60,\"premiered\":\"1947-11-06T00:00:00+00:00\",\"officialSite\":\"http://www.nbcnews.com/meet-the-press\",\"schedule\":{\"time\":\"09:00\",\"days\":[\"Sunday\"]},\"rating\":{\"average\":null},\"weight\":0,\"network\":{\"id\":1,\"name\":\"NBC\",\"country\":{\"name\":\"United States\",\"code\":\"US\",\"timezone\":\"America/New_York\"}},\"webChannel\":null,\"externals\":{\"tvrage\":null,\"thetvdb\":74657,\"imdb\":null},\"image\":{\"medium\":\"http://static.tvmaze.com/uploads/images/medium_portrait/31/78377.jpg\",\"original\":\"http://static.tvmaze.com/uploads/images/original_untouched/31/78377.jpg\"},\"summary\":\"<p>For almost as long as there has been television, there's been <b>Meet the Press</b>. The hourlong Sunday morning public affairs program has featured interviews with countless U.S. and world leaders, and has reviewed, analyzed and discussed the news of the week -- all while looking toward the week ahead.</p>\",\"updated\":1517663826,\"_links\":{\"self\":{\"href\":\"http://api.tvmaze.com/shows/8835\"},\"previousepisode\":{\"href\":\"http://api.tvmaze.com/episodes/1404176\"},\"nextepisode\":{\"href\":\"http://api.tvmaze.com/episodes/1404177\"}}},\"_links\":{\"self\":{\"href\":\"http://api.tvmaze.com/episodes/1404177\"}}}]"
}
