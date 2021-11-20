package com.voidx.show.data.di

import com.voidx.show.data.api.ShowsAPI
import com.voidx.show.data.respository.ShowsRepository
import com.voidx.show.data.respository.impl.RemoteShowsRepository
import org.koin.dsl.module
import retrofit2.Retrofit

val showDataModule = module {

    factory<ShowsRepository> {
        RemoteShowsRepository(get())
    }

    single {
        createShowAPI(get())
    }
}

internal fun createShowAPI(retrofit: Retrofit): ShowsAPI {
    return retrofit.create(ShowsAPI::class.java)
}