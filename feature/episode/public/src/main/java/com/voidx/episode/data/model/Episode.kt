package com.voidx.episode.data.model

import com.google.gson.annotations.SerializedName
import com.voidx.common.data.Image

data class Episode(
    @SerializedName("id") val id: Int,
    @SerializedName("season") val season: Int,
    @SerializedName("number") val number: Int,
    @SerializedName("image") val image: Image?,
    @SerializedName("summary") val description: String?,
    @SerializedName("name") val name: String?,
)