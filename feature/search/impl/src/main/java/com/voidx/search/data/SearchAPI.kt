package com.voidx.search.data

import com.voidx.search.data.model.SearchResult
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchAPI {

    @GET("search/shows")
    fun searchShow(@Query("q") query: String): Single<List<SearchResult>>
}