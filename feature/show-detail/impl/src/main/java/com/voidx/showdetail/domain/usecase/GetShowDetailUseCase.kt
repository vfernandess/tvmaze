package com.voidx.showdetail.domain.usecase

import com.voidx.show.data.respository.ShowsRepository
import com.voidx.showdetail.domain.mapper.ShowDetailDomainMapper
import com.voidx.showdetail.domain.model.ShowDetail
import io.reactivex.rxjava3.core.Single

interface GetShowDetailUseCase {

    fun getShowDetail(showID: Int): Single<List<ShowDetail>>

    class Impl(
        private val repository: ShowsRepository,
        private val mapper: ShowDetailDomainMapper
    ): GetShowDetailUseCase {

        override fun getShowDetail(showID: Int): Single<List<ShowDetail>> {
            return repository
                .getShowDetail(showID)
                .map(mapper::map)
        }
    }
}