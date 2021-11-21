package com.voidx.search.navigator

import com.voidx.core.navigator.Navigator
import com.voidx.search.ui.view.SearchFragment
import com.voidx.showdetail.navigator.ShowDetailNavigator

class SearchNavigatorImpl(
    private val navigator: Navigator,
    private val showDetailNavigator: ShowDetailNavigator
): SearchNavigator {

    override fun search(query: String?) {
        navigator.navigateTo(SearchFragment.newInstance(query))
    }

    override fun showDetail(showID: Int) {
        showDetailNavigator.showDetail(showID)
    }
}