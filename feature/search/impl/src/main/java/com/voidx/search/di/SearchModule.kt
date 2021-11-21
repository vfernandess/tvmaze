package com.voidx.search.di

import com.voidx.search.data.SearchAPI
import com.voidx.search.data.repository.SearchRepository
import com.voidx.search.data.repository.impl.RemoteSearchRepositoryImpl
import com.voidx.search.domain.mapper.SearchResultDomainMapper
import com.voidx.search.domain.usecase.SearchShowUseCase
import com.voidx.search.navigator.SearchNavigator
import com.voidx.search.navigator.SearchNavigatorImpl
import com.voidx.search.ui.presentation.SearchShowViewModel
import com.voidx.search.ui.view.SearchFragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val searchModule = module {

    factory<SearchNavigator> {
        SearchNavigatorImpl(get(), get())
    }

    factory<SearchResultDomainMapper> {
        SearchResultDomainMapper.Impl(get())
    }

    factory<SearchRepository> {
        RemoteSearchRepositoryImpl(get())
    }

    single {
        createSearchAPI(get())
    }

    scope<SearchFragment> {

        scoped<SearchShowUseCase> {
            SearchShowUseCase.Impl(get(), get())
        }

        viewModel {
            SearchShowViewModel(get())
        }
    }
}

internal fun createSearchAPI(retrofit: Retrofit): SearchAPI {
    return retrofit.create(SearchAPI::class.java)
}