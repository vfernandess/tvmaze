package com.voidx.showdetail.ui.detail.view.adapter.builder

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.voidx.core.view.binding.adapterDelegateLayoutBinding
import com.voidx.episode.domain.model.EpisodeDTO
import com.voidx.showdetail.domain.model.ShowDetail
import com.voidx.showdetail.domain.model.ShowDetailSeasonDTO
import com.voidx.showdetail.impl.R
import com.voidx.showdetail.impl.databinding.EpisodeBySeasonViewBinding
import com.voidx.showdetail.impl.databinding.EpisodeShowDetailViewBinding

object EpisodesBySeasonViewBuilder {

    fun build() =
        adapterDelegateLayoutBinding<ShowDetailSeasonDTO, ShowDetail, EpisodeBySeasonViewBinding>(
            layout = R.layout.episode_by_season_view
        )
        {

            val adapter = ListDelegationAdapter(
                EpisodeViewBuilder.build()
            )

            onViewAttachedToWindow {
                binding.list.adapter = adapter
                binding.seasonChooser.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        updateEpisodes(adapter, item.seasons[position].episodes)
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                    }
                }
            }

            bind {

                binding.seasonChooser.adapter = ArrayAdapter(
                    itemView.context,
                    android.R.layout.simple_dropdown_item_1line,
                    item.seasons
                )

                updateEpisodes(adapter, item.seasons[0].episodes)
            }
        }

    private fun updateEpisodes(adapter: ListDelegationAdapter<List<Any>>, items: List<EpisodeDTO>) {
        adapter.items = items
        adapter.notifyDataSetChanged()
    }
}

object EpisodeViewBuilder {

    fun build() =
        adapterDelegateLayoutBinding<EpisodeDTO, Any, EpisodeShowDetailViewBinding>(
            layout = R.layout.episode_show_detail_view
        ) {
            bind {
                binding.episode = item
            }
        }
}