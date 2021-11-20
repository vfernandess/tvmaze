package com.voidx.shows.domain.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.voidx.common.domain.model.ImageDTO
import com.voidx.shows.BR

open class ShowDTO(val id: Int): BaseObservable() {

    @Bindable
    var title: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.title)
        }

    @Bindable
    var genres: String? = null
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
    var realRating: Float = 0f
        set(value) {
            field = value
            notifyPropertyChanged(BR.realRating)
        }

    @Bindable
    var image: ImageDTO? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.image)
        }

    @Bindable
    fun getFormattedRating(): String {
        return "$realRating/10"
    }

    @Bindable
    fun getRating(): Float {
        return realRating / 2
    }
}