package com.voidx.show.data.api

import com.voidx.show.data.model.Show
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface ShowsAPI {

    @GET("/shows/{show_id}?embed[]=cast&embed[]=episodes")
    fun getShowDetail(@Path("show_id") showID: Int): Single<Show>

    @GET("/shows")
    fun listShows(@Query("page") page: Int): Single<List<Show>>
}