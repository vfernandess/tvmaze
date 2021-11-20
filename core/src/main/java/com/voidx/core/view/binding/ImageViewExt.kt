package com.voidx.core.view.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("url")
fun ImageView.load(url: String?) {
    Glide
        .with(this)
        .load(url)
        .into(this)
}

@BindingAdapter("url_with_roundCorner")
fun ImageView.loadRoundCorners(url: String?) {
    Glide
        .with(this)
        .load(url)
        .apply(RequestOptions.bitmapTransform(RoundedCorners(30)))
        .into(this)
}