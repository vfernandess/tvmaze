package com.voidx.common.domain.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.voidx.common.BR

class ImageDTO: BaseObservable() {

    @Bindable
    var medium: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.medium)
        }

    @Bindable
    var original: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.original)
        }
}