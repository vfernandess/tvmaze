package com.voidx.search.ui.view.adapter

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.voidx.shows.view.item.OnShowClicked
import com.voidx.shows.view.item.ShowViewBuilder

class SearchShowDelegate(onShowClicked: OnShowClicked?) {

    val adapter by lazy {
        ListDelegationAdapter(
            ShowViewBuilder.build(onShowClicked)
        )
    }
}