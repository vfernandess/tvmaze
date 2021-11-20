package com.voidx.shows.data.api

import com.voidx.shows.data.Show
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ShowsAPI {

    @GET("/shows/{show_id}?embed[]=cast&embed[]=episodes")
    fun getShowDetail(showID: Int): Single<Show>

    @GET("/shows")
    fun listShows(@Query("page") page: Int): Single<List<Show>>
}