package com.voidx.search.data.repository.impl

import com.voidx.search.data.SearchAPI
import com.voidx.search.data.model.SearchResult
import com.voidx.search.data.repository.SearchRepository
import io.reactivex.rxjava3.core.Single

class RemoteSearchRepositoryImpl(
    private val api: SearchAPI
): SearchRepository {

    override fun searchShow(query: String): Single<List<SearchResult>> {
        return api.searchShow(query)
    }
}