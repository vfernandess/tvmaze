package com.voidx.showdetail.navigator

import com.voidx.episode.domain.model.EpisodeDTO

interface ShowDetailNavigator {

    fun showDetail(showId: Int)

    fun showEpisode(episode: EpisodeDTO)

    fun goBack()
}