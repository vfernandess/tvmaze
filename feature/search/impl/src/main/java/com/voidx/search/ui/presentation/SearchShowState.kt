package com.voidx.search.ui.presentation

import com.voidx.shows.domain.model.ShowDTO

sealed class SearchShowState {
    object Loading: SearchShowState()

    data class LoadItems(
        val items: List<ShowDTO>
    ): SearchShowState()

    object Error: SearchShowState()
}