package com.voidx.shows.ui.home.view

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.voidx.shows.view.item.OnShowClicked
import com.voidx.shows.view.item.ShowViewBuilder

class HomeShowsDelegate(
    onShowClicked: OnShowClicked?
) {

    val adapter by lazy {
        ListDelegationAdapter(
            ShowViewBuilder.build(onShowClicked)
        )
    }
}