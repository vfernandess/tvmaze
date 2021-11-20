package com.voidx.show.data.respository

import com.voidx.show.data.model.Show
import io.reactivex.rxjava3.core.Single

interface ShowsRepository {

    fun getShowDetail(showID: Int): Single<Show>

    fun listShows(page: Int): Single<List<Show>>
}