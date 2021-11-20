package com.voidx.tvmaze

import android.app.Application
import com.voidx.common.di.commonModule
import com.voidx.core.network.networkModule
import com.voidx.episode.di.episodeModule
import com.voidx.shows.di.showsModule
import org.koin.core.context.startKoin

class TvMazeApp: Application() {

    override fun onCreate() {
        super.onCreate()


        startKoin {
            modules(networkModule, commonModule, showsModule, episodeModule)
        }
    }
}