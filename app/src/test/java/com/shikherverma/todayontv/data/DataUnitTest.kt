package com.shikherverma.todayontv.data

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.shikherverma.todayontv.model.Episode
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test


/**
 * unit test [com.shikherverma.todayontv.data]
 */
class DataUnitTest {

    @Test
    fun testEpisodesListDeserialization() {
        val gson = Gson()
        val actualEpisodes: ArrayList<Episode> = gson.fromJson(DataFactory.jsonResponse, object : TypeToken<ArrayList<Episode>>() {}.type)
        val expectedPosts = DataFactory.parseListOfPosts()
        assertThat<List<Episode>>(actualEpisodes, `is`<List<Episode>>(expectedPosts))
    }
}