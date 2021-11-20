package com.voidx.shows.domain.mapper

import com.voidx.shows.data.Show
import com.voidx.shows.domain.model.ShowDTO

interface ShowDomainMapper {

    fun map(from: Show): ShowDTO
}