package com.voidx.showdetail.di

import com.voidx.showdetail.domain.mapper.ShowDetailDomainMapper
import com.voidx.showdetail.domain.usecase.GetShowDetailUseCase
import com.voidx.showdetail.navigator.ShowDetailNavigator
import com.voidx.showdetail.navigator.ShowDetailNavigatorImpl
import com.voidx.showdetail.ui.detail.presentation.ShowDetailViewModel
import com.voidx.showdetail.ui.detail.view.ShowDetailFragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val showDetailModule = module {

    factory<ShowDetailDomainMapper> {
        ShowDetailDomainMapper.Impl(get(), get())
    }

    factory<ShowDetailNavigator> {
        ShowDetailNavigatorImpl(get())
    }

    scope<ShowDetailFragment> {

        scoped<GetShowDetailUseCase> {
            GetShowDetailUseCase.Impl(get(), get())
        }

        viewModel {
            ShowDetailViewModel(get())
        }
    }
}