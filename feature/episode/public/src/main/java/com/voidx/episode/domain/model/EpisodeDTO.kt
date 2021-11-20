package com.voidx.episode.domain.model

import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.voidx.common.domain.model.ImageDTO
import com.voidx.episode.BR
import kotlinx.parcelize.Parcelize

@Parcelize
class EpisodeDTO(
    val id: Int
): BaseObservable(), Parcelable {

    @Bindable
    var season: Int = -1
        set(value) {
            field = value
            notifyPropertyChanged(BR.season)
        }

    @Bindable
    var number: Int = -1
        set(value) {
            field = value
            notifyPropertyChanged(BR.number)
        }

    @Bindable
    var image: ImageDTO? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.image)
        }

    @Bindable
    var description: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.season)
        }

    @Bindable
    var name: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    @Bindable
    fun getTitle(): String =
        "S$season:E$number"
}