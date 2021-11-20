package com.voidx.showdetail.ui.detail.view.adapter

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.voidx.showdetail.ui.detail.view.adapter.builder.EpisodesBySeasonViewBuilder
import com.voidx.showdetail.ui.detail.view.adapter.builder.OnEpisodeClicked
import com.voidx.showdetail.ui.detail.view.adapter.builder.ShowInfoViewBuilder

class ShowDetailDelegate(onEpisodeClicked: OnEpisodeClicked?) {

    val adapter by lazy {
        ListDelegationAdapter(
            ShowInfoViewBuilder.build(),
            EpisodesBySeasonViewBuilder.build(onEpisodeClicked)
        )
    }
}