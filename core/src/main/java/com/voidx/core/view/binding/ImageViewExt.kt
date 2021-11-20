package com.voidx.core.view.binding

import android.content.res.Resources
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.load.resource.bitmap.RoundedCorners as GlideRoundedCorners
import com.voidx.core.view.util.RoundedCorners as ProjectRoundedCorners

@BindingAdapter("url")
fun ImageView.load(url: String?) {
    Glide
        .with(this)
        .load(url)
        .into(this)
}

@BindingAdapter("url_all_roundCorner")
fun ImageView.loadAllRoundCorners(url: String?) {
    Glide
        .with(this)
        .load(url)
        .apply(RequestOptions.bitmapTransform(GlideRoundedCorners(30)))
        .into(this)
}

@BindingAdapter("url_top_roundCorner")
fun ImageView.loadTopRoundCorners(url: String?) {

    val size =
        (Resources.getSystem().displayMetrics.density * 30).toInt()

    Glide
        .with(this)
        .load(url)
        .apply(
            RequestOptions.bitmapTransform(
                ProjectRoundedCorners(
                    topLeft = size,
                    topRight = size,
                    bottomRight = 0, bottomLeft = 0
                )
            )
        )
        .into(this)
}