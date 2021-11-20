package com.voidx.showdetail.ui.detail.presentation

import com.voidx.showdetail.domain.model.ShowDetail

sealed class ShowDetailState {

    object Loading: ShowDetailState()

    data class LoadItems(
        val poster: String?,
        val list: List<ShowDetail>
    ): ShowDetailState()

    object Error: ShowDetailState()
}
