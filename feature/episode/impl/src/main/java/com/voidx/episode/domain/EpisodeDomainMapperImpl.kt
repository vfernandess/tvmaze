package com.voidx.episode.domain

import com.voidx.common.domain.mapper.ImageDomainMapper
import com.voidx.episode.data.model.Episode
import com.voidx.episode.domain.mapper.EpisodeDomainMapper
import com.voidx.episode.domain.model.EpisodeDTO
import com.voidx.episode.domain.model.SeasonDTO

internal class EpisodeDomainMapperImpl(
    private val mapper: ImageDomainMapper
) : EpisodeDomainMapper {
    override fun map(from: Episode): EpisodeDTO {
        return EpisodeDTO(from.id).apply {
            description = from.description
            season = from.season
            number = from.number
            image = from.image?.let(mapper::map)
            name = from.name
        }
    }

    override fun mapSeasons(episodes: List<Episode>): List<SeasonDTO> {
        return episodes
            .groupBy(
                keySelector = { it.season },
                valueTransform = { map(it) }
            )
            .mapTo(mutableListOf()) {
                SeasonDTO().apply {
                    number = it.key
                    this.episodes = it.value
                }
            }
    }
}