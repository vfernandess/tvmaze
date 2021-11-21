package com.voidx.search.navigator

interface SearchNavigator {

    fun search(query: String?)

    fun showDetail(showID: Int)
}