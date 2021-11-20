package com.voidx.shows.ui.home.presentation

import com.voidx.shows.domain.model.ShowDTO

sealed class HomeShowsState {

    object Loading: HomeShowsState()

    data class LoadItems(
        val items: List<ShowDTO>
    ): HomeShowsState()

    object Error: HomeShowsState()
}