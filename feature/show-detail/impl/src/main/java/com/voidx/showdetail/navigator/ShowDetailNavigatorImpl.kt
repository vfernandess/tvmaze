package com.voidx.showdetail.navigator

import com.voidx.core.navigator.Navigator
import com.voidx.episode.domain.model.EpisodeDTO
import com.voidx.episode.navigator.EpisodeNavigator
import com.voidx.showdetail.ui.detail.view.ShowDetailFragment

internal class ShowDetailNavigatorImpl(
    private val navigator: Navigator,
    private val episodeNavigator: EpisodeNavigator
): ShowDetailNavigator {

    override fun showDetail(showId: Int) {
        navigator.navigateTo(ShowDetailFragment.newInstance(showId))
    }

    override fun showEpisode(episode: EpisodeDTO) {
        episodeNavigator.showEpisode(episode)
    }

    override fun goBack() {
        navigator.goBack()
    }
}