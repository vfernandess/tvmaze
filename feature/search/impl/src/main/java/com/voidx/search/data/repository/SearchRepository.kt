package com.voidx.search.data.repository

import com.voidx.search.data.model.SearchResult
import io.reactivex.rxjava3.core.Single

interface SearchRepository {

    fun searchShow(query: String): Single<List<SearchResult>>
}