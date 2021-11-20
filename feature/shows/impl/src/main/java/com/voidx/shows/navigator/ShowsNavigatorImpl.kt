package com.voidx.shows.navigator

import com.voidx.core.navigator.Navigator
import com.voidx.showdetail.navigator.ShowDetailNavigator
import com.voidx.shows.ui.home.view.HomeShowsFragment

internal class ShowsNavigatorImpl(
    private val navigator: Navigator,
    private val showDetailNavigator: ShowDetailNavigator
): ShowsNavigator {

    override fun showHome() {
        navigator.navigateTo(HomeShowsFragment())
    }

    override fun showDetail(showID: Int) {
        showDetailNavigator.showDetail(showID)
    }
}