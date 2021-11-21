package com.voidx.search.domain.mapper

import com.voidx.search.data.model.SearchResult
import com.voidx.shows.domain.mapper.ShowDomainMapper
import com.voidx.shows.domain.model.ShowDTO

interface SearchResultDomainMapper {

    fun map(result: List<SearchResult>): List<ShowDTO>

    class Impl(
        private val showDomainMapper: ShowDomainMapper
    ) : SearchResultDomainMapper {

        override fun map(result: List<SearchResult>): List<ShowDTO> {
            return result.mapNotNull {
                if (it.show == null)
                    null
                else {
                    showDomainMapper.map(it.show)
                }
            }
        }
    }
}