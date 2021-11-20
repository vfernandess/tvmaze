package com.voidx.shows.di

import com.voidx.shows.domain.mapper.ShowDomainMapper
import com.voidx.shows.domain.mapper.impl.ShowDomainMapperImpl
import com.voidx.shows.domain.usecase.ListShowsByPageUseCase
import com.voidx.shows.domain.usecase.impl.ListShowsByPageUseCaseImpl
import com.voidx.shows.navigator.ShowsNavigator
import com.voidx.shows.navigator.ShowsNavigatorImpl
import com.voidx.shows.ui.home.presentation.HomeViewModel
import com.voidx.shows.ui.home.view.HomeShowsFragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val showsModule = module {

    factory<ShowsNavigator> {
        ShowsNavigatorImpl(get(), get())
    }

    factory<ShowDomainMapper> {
        ShowDomainMapperImpl(get())
    }

    scope<HomeShowsFragment> {

        scoped<ListShowsByPageUseCase> {
            ListShowsByPageUseCaseImpl(get(), get())
        }

        viewModel {
            HomeViewModel(get())
        }
    }
}