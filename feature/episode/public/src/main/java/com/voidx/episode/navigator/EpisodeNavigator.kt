package com.voidx.episode.navigator

import com.voidx.episode.domain.model.EpisodeDTO

interface EpisodeNavigator {

    fun showEpisode(episodeDTO: EpisodeDTO)
}