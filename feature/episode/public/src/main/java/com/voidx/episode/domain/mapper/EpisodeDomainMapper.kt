package com.voidx.episode.domain.mapper

import com.voidx.episode.data.model.Episode
import com.voidx.episode.domain.model.EpisodeDTO

interface EpisodeDomainMapper {

    fun map(from: Episode): EpisodeDTO
}