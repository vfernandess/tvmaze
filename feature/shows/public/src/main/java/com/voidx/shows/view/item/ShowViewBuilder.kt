package com.voidx.shows.view.item

import com.voidx.core.view.binding.adapterDelegateLayoutBinding
import com.voidx.shows.R
import com.voidx.shows.databinding.ShowItemBinding
import com.voidx.shows.domain.model.ShowDTO

typealias OnShowClicked = ((show: ShowDTO?) -> Unit)

object ShowViewBuilder {

    fun build(onShowClicked: OnShowClicked?) =
        adapterDelegateLayoutBinding<ShowDTO, Any, ShowItemBinding>(layout = R.layout.show_item)
        {
            bind {
                binding.show = item
                binding.root.setOnClickListener {
                    onShowClicked?.invoke(binding.show)
                }
            }
        }

}