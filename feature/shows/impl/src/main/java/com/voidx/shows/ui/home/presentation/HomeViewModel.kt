package com.voidx.shows.ui.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.voidx.shows.domain.model.ShowDTO
import com.voidx.shows.domain.usecase.ListShowsByPageUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel(
    private val listShowsByPageUseCase: ListShowsByPageUseCase
) : ViewModel() {

    private val disposables = CompositeDisposable()

    private val state = MutableLiveData<HomeShowsState>()

    fun state(): LiveData<HomeShowsState> = state

    fun load() {
        state.postValue(HomeShowsState.Loading)

        loadMore()
    }

    fun loadMore() {
        listShowsByPageUseCase
            .listShows()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::handleSuccess, ::handleError)
            .also { disposables.add(it) }
    }

    private fun handleError(throwable: Throwable) {
        state.postValue(HomeShowsState.Error)
    }

    private fun handleSuccess(list: List<ShowDTO>?) {
        state.postValue(
            HomeShowsState.LoadItems(list ?: emptyList())
        )
    }

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }
}