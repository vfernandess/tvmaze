package com.voidx.episode.domain.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.voidx.episode.BR

open class SeasonDTO : BaseObservable() {

    @Bindable
    var number: Int = -1
        set(value) {
            field = value
            notifyPropertyChanged(BR.number)
        }

    @Bindable
    var episodes: List<EpisodeDTO> = listOf()
        set(value) {
            field = value
            notifyPropertyChanged(BR.episodes)
        }

    @Bindable
    fun getName(): String {
        return "Season $number"
    }

    override fun toString(): String = getName()
}