package com.voidx.episode.domain.mapper

import com.voidx.episode.data.model.Episode
import com.voidx.episode.domain.model.EpisodeDTO
import com.voidx.episode.domain.model.SeasonDTO

interface EpisodeDomainMapper {

    fun map(from: Episode): EpisodeDTO

    fun mapSeasons(episodes: List<Episode>): List<SeasonDTO>
}