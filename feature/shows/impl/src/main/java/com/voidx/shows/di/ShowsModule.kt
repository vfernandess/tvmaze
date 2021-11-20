package com.voidx.shows.di

import com.voidx.core.navigator.Navigator
import com.voidx.shows.data.api.ShowsAPI
import com.voidx.shows.data.respository.ShowsRepository
import com.voidx.shows.data.respository.impl.RemoteShowsRepository
import com.voidx.shows.domain.mapper.ShowDomainMapper
import com.voidx.shows.domain.mapper.impl.ShowDomainMapperImpl
import com.voidx.shows.domain.usecase.ListShowsByPageUseCase
import com.voidx.shows.domain.usecase.impl.ListShowsByPageUseCaseImpl
import com.voidx.shows.ui.home.presentation.HomeViewModel
import com.voidx.shows.ui.home.view.HomeShowsFragment
import com.voidx.shows.navigator.ShowsNavigator
import com.voidx.shows.navigator.ShowsNavigatorImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val showsModule = module {

    factory<ShowsNavigator> { (navigator: Navigator) ->
        ShowsNavigatorImpl(navigator)
    }

    factory<ShowDomainMapper> {
        ShowDomainMapperImpl(get(), get())
    }

    single {
        createShowAPI(get())
    }

    scope<HomeShowsFragment> {

        scoped<ShowsRepository> {
            RemoteShowsRepository(get())
        }

        scoped<ListShowsByPageUseCase> {
            ListShowsByPageUseCaseImpl(get(), get())
        }

        viewModel {
            HomeViewModel(get())
        }
    }
}

fun createShowAPI(retrofit: Retrofit): ShowsAPI {
    return retrofit.create(ShowsAPI::class.java)
}