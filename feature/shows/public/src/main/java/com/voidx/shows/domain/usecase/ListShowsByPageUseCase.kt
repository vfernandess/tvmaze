package com.voidx.shows.domain.usecase

import com.voidx.shows.domain.model.ShowDTO
import io.reactivex.rxjava3.core.Single

interface ListShowsByPageUseCase {

    fun listShows(): Single<List<ShowDTO>>
}