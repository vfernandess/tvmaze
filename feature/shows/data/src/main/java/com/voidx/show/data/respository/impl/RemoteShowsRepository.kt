package com.voidx.show.data.respository.impl

import com.voidx.show.data.api.ShowsAPI
import com.voidx.show.data.model.Show
import com.voidx.show.data.respository.ShowsRepository
import io.reactivex.rxjava3.core.Single

internal class RemoteShowsRepository(
    private val api: ShowsAPI
): ShowsRepository {
    override fun getShowDetail(showID: Int): Single<Show> {
        return api.getShowDetail(showID)
    }

    override fun listShows(page: Int): Single<List<Show>> {
        return api.listShows(page)
    }
}