package com.voidx.core.view.adapter

import com.hannesdorfmann.adapterdelegates4.AbsDelegationAdapter

fun <T> AbsDelegationAdapter<List<T>>.addItems(newItems: List<T>) {
    val positionStart: Int
    if (items == null) {
        positionStart = 0
        items = newItems
    } else {
        positionStart = itemCount
        items += newItems
    }
    notifyItemRangeInserted(positionStart, newItems.size)
}