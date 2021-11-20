package com.voidx.showdetail.navigator

import com.voidx.core.navigator.Navigator
import com.voidx.showdetail.ui.detail.view.ShowDetailFragment

internal class ShowDetailNavigatorImpl(
    private val navigator: Navigator
): ShowDetailNavigator {

    override fun showDetail(showId: Int) {
        navigator.navigateTo(ShowDetailFragment.newInstance(showId))
    }

    override fun goBack() {
        navigator.goBack()
    }
}