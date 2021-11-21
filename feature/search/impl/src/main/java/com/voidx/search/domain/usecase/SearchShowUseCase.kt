package com.voidx.search.domain.usecase

import com.voidx.search.data.repository.SearchRepository
import com.voidx.search.domain.mapper.SearchResultDomainMapper
import com.voidx.shows.domain.model.ShowDTO
import io.reactivex.rxjava3.core.Single

interface SearchShowUseCase {

    fun search(query: String): Single<List<ShowDTO>>

    class Impl(
        private val mapper: SearchResultDomainMapper,
        private val repository: SearchRepository
    ) : SearchShowUseCase {

        override fun search(query: String): Single<List<ShowDTO>> {
            return repository
                .searchShow(query)
                .map(mapper::map)
        }
    }
}