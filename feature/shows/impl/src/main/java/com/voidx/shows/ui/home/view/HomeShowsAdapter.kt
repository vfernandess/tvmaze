package com.voidx.shows.ui.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.voidx.shows.databinding.ShowItemBinding
import com.voidx.shows.domain.model.ShowDTO
import com.voidx.shows.view.item.OnShowClicked
import com.voidx.shows.view.item.ShowViewHolder

class HomeShowsAdapter(
    private val onShowClicked: OnShowClicked
) : RecyclerView.Adapter<ShowViewHolder>() {

    private val list = mutableListOf<ShowDTO>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val binding = ShowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShowViewHolder(binding, onShowClicked)
    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        list.getOrNull(position)?.let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int = list.size

    fun addItems(items: List<ShowDTO>) {
        val positionStart = list.size
        list.addAll(items)
        notifyItemRangeInserted(positionStart, items.size)
    }
}