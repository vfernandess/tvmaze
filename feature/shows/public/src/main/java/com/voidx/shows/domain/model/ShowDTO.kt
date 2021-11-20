package com.voidx.shows.domain.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.voidx.common.domain.model.ImageDTO
import com.voidx.episode.domain.model.EpisodeDTO
import com.voidx.shows.BR

class ShowDTO(val id: Int): BaseObservable() {

    @Bindable
    var title: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.title)
        }

    @Bindable
    var genres: List<String>? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.genres)
        }

    @Bindable
    var description: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.description)
        }

    @Bindable
    var rating: Float = 0f
        set(value) {
            field = value
            notifyPropertyChanged(BR.rating)
        }

    @Bindable
    var image: ImageDTO? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.image)
        }

    @Bindable
    var episodes: List<EpisodeDTO>? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.episodes)
        }
}