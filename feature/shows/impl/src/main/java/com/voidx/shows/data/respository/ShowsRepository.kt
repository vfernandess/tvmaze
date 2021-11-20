package com.voidx.shows.data.respository

import com.voidx.shows.data.Show
import io.reactivex.rxjava3.core.Single

interface ShowsRepository {

    fun getShowDetail(showID: Int): Single<Show>

    fun listShows(page: Int): Single<List<Show>>
}