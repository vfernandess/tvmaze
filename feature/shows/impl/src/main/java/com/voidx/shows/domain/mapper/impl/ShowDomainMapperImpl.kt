package com.voidx.shows.domain.mapper.impl

import com.voidx.common.domain.mapper.ImageDomainMapper
import com.voidx.show.data.model.Show
import com.voidx.shows.domain.mapper.ShowDomainMapper
import com.voidx.shows.domain.model.ShowDTO

internal class ShowDomainMapperImpl(
    private val imageMapper: ImageDomainMapper
): ShowDomainMapper {

    override fun map(from: Show): ShowDTO {
        return ShowDTO(id = from.id).apply {
            title = from.title
            description = from.description
            image = from.image?.let(imageMapper::map)
            realRating = from.rating?.average ?: 0f
        }
    }
}