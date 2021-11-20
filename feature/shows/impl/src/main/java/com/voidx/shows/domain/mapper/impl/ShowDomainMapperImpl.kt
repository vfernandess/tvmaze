package com.voidx.shows.domain.mapper.impl

import com.voidx.common.domain.mapper.ImageDomainMapper
import com.voidx.episode.domain.mapper.EpisodeDomainMapper
import com.voidx.shows.data.Show
import com.voidx.shows.domain.mapper.ShowDomainMapper
import com.voidx.shows.domain.model.ShowDTO

class ShowDomainMapperImpl(
    private val episodeMapper: EpisodeDomainMapper,
    private val imageMapper: ImageDomainMapper
): ShowDomainMapper {

    override fun map(from: Show): ShowDTO {
        return ShowDTO(id = from.id).apply {
            title = from.title
            genres = from.genres
            description = from.description
            image = from.image?.let(imageMapper::map)
            rating = from.rating?.average ?: 0f
            episodes = from.embedded?.episodes?.map(episodeMapper::map)
        }
    }
}