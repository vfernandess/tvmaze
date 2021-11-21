package com.voidx.search.ui.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.voidx.search.domain.usecase.SearchShowUseCase
import com.voidx.shows.domain.model.ShowDTO
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class SearchShowViewModel(
    private val useCase: SearchShowUseCase
) : ViewModel() {

    private val disposables = CompositeDisposable()

    private val state = MutableLiveData<SearchShowState>()

    fun state(): LiveData<SearchShowState> = state

    fun load(query: String?) {
        state.postValue(SearchShowState.Loading)

        if (query.isNullOrBlank()) {
            state.postValue(SearchShowState.Error)
        } else {
            search(query)
        }
    }

    private fun search(query: String) {
        useCase
            .search(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::handleSuccess, ::handleError)
            .also { disposables.add(it) }
    }

    private fun handleError(throwable: Throwable) {
        state.postValue(SearchShowState.Error)
    }

    private fun handleSuccess(list: List<ShowDTO>) {
        state.postValue(SearchShowState.LoadItems(list))
    }
}