package com.voidx.showdetail.domain.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.voidx.episode.domain.model.SeasonDTO
import com.voidx.shows.BR

class ShowDetailSeasonDTO: BaseObservable(), ShowDetail {

    @Bindable
    var seasons: List<SeasonDTO> = emptyList()
        set(value) {
            field = value
            notifyPropertyChanged(BR.season)
        }
}