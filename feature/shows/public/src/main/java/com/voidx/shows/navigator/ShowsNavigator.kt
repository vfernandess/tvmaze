package com.voidx.shows.navigator

interface ShowsNavigator {

    fun showHome()

    fun showDetail(showID: Int)

    fun search(query: String?)
}