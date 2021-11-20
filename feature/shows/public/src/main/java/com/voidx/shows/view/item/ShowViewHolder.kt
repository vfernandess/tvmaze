package com.voidx.shows.view.item

import androidx.recyclerview.widget.RecyclerView
import com.voidx.shows.databinding.ShowItemBinding
import com.voidx.shows.domain.model.ShowDTO

typealias OnShowClicked = ((show: ShowDTO?) -> Unit)

class ShowViewHolder(
    private val binding: ShowItemBinding,
    private val onShowClicked: OnShowClicked?
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(show: ShowDTO) {
        binding.show = show
        binding.root.setOnClickListener {
            onShowClicked?.invoke(binding.show)
        }
    }
}