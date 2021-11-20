package com.voidx.shows.data.respository.impl

import com.voidx.shows.data.Show
import com.voidx.shows.data.api.ShowsAPI
import com.voidx.shows.data.respository.ShowsRepository
import io.reactivex.rxjava3.core.Single

class RemoteShowsRepository(
    private val api: ShowsAPI
): ShowsRepository {
    override fun getShowDetail(showID: Int): Single<Show> {
        return api.getShowDetail(showID)
    }

    override fun listShows(page: Int): Single<List<Show>> {
        return api.listShows(page)
    }
}