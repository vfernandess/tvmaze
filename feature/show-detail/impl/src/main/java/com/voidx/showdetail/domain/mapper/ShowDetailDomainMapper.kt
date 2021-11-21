package com.voidx.showdetail.domain.mapper

import com.voidx.common.domain.mapper.ImageDomainMapper
import com.voidx.episode.data.model.Episode
import com.voidx.episode.domain.mapper.EpisodeDomainMapper
import com.voidx.show.data.model.Show
import com.voidx.show.data.model.ShowSchedule
import com.voidx.showdetail.domain.model.ShowDetail
import com.voidx.showdetail.domain.model.ShowDetailDTO
import com.voidx.showdetail.domain.model.ShowDetailSeasonDTO

interface ShowDetailDomainMapper {

    fun map(show: Show): List<ShowDetail>

    class Impl(
        private val imageMapper: ImageDomainMapper,
        private val episodeMapper: EpisodeDomainMapper
    ) : ShowDetailDomainMapper {

        override fun map(show: Show): List<ShowDetail> {

            val items = mutableListOf<ShowDetail>()

            items.add(mapShow(show))
            mapSeasons(show.embedded?.episodes)?.also(items::add)

            return items
        }

        private fun mapSeasons(episodes: List<Episode>?): ShowDetail? {
            if(episodes.isNullOrEmpty()) {
                return null
            }

            return ShowDetailSeasonDTO().apply {
                seasons = episodeMapper.mapSeasons(episodes)
            }
        }

        private fun mapShow(show: Show): ShowDetail {
            return ShowDetailDTO(id = show.id)
                .apply {
                    title = show.title
                    genres = show.genres?.joinToString(separator = ", ")
                    description = show.description
                    image = show.image?.let(imageMapper::map)
                    realRating = show.rating?.average ?: 0f
                    schedule = mapSchedule(show.schedule)
                }
        }

        private fun mapSchedule(schedule: ShowSchedule?): String? {
            return schedule?.days
                ?.joinToString(separator = "s, ")
                ?.let {
                    "On $it at ${schedule.time}"
                }
        }
    }
}