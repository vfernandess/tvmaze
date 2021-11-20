package com.voidx.shows.domain.usecase.impl

import com.voidx.shows.data.respository.ShowsRepository
import com.voidx.shows.domain.mapper.ShowDomainMapper
import com.voidx.shows.domain.model.ShowDTO
import com.voidx.shows.domain.usecase.ListShowsByPageUseCase
import io.reactivex.rxjava3.core.Single

class ListShowsByPageUseCaseImpl(
    private val repository: ShowsRepository,
    private val mapper: ShowDomainMapper,
    var page: Int = 0
): ListShowsByPageUseCase {

    override fun listShows(): Single<List<ShowDTO>> {
        return repository
            .listShows(page)
            .map { it.map { show -> mapper.map(show) } }
            .doOnSuccess { page++ }
    }
}