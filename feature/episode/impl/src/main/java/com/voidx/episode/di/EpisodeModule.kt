package com.voidx.episode.di

import com.voidx.episode.domain.EpisodeDomainMapperImpl
import com.voidx.episode.domain.mapper.EpisodeDomainMapper
import com.voidx.episode.navigator.EpisodeNavigator
import com.voidx.episode.navigator.EpisodeNavigatorImpl
import org.koin.dsl.module

val episodeModule = module {

    factory<EpisodeDomainMapper> {
        EpisodeDomainMapperImpl(get())
    }

    factory<EpisodeNavigator> {
        EpisodeNavigatorImpl(get())
    }
}