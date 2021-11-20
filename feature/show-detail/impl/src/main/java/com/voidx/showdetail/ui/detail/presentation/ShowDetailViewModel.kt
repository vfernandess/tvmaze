package com.voidx.showdetail.ui.detail.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.voidx.showdetail.domain.model.ShowDetail
import com.voidx.showdetail.domain.model.ShowDetailDTO
import com.voidx.showdetail.domain.usecase.GetShowDetailUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class ShowDetailViewModel(
    private val showDetailUseCase: GetShowDetailUseCase
) : ViewModel() {

    private val disposables = CompositeDisposable()

    private val state = MutableLiveData<ShowDetailState>()

    fun state(): LiveData<ShowDetailState> = state

    fun load(showID: Int) {
        state.postValue(ShowDetailState.Loading)

        showDetailUseCase
            .getShowDetail(showID)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::handleSuccess, ::handleError)
            .also(disposables::add)
    }

    private fun handleError(throwable: Throwable) {
        state.postValue(ShowDetailState.Error)
    }

    private fun handleSuccess(list: List<ShowDetail>) {
        val show = list.filterIsInstance<ShowDetailDTO>().firstOrNull()

        state.postValue(
            ShowDetailState.LoadItems(
                poster = show?.image?.medium,
                list = list
            )
        )
    }
}