package com.voidx.episode.navigator

import com.voidx.core.navigator.Navigator
import com.voidx.episode.domain.model.EpisodeDTO
import com.voidx.episode.ui.view.EpisodeDetailFragment

class EpisodeNavigatorImpl(
    private val navigator: Navigator
): EpisodeNavigator {

    override fun showEpisode(episodeDTO: EpisodeDTO) {
        val fragment = EpisodeDetailFragment.newInstance(episodeDTO)
        fragment.show(navigator.getSupportFragmentManager(), "EDF")
    }
}