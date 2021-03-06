package com.voidx.show.data.model

import com.google.gson.annotations.SerializedName
import com.voidx.common.data.Image
import com.voidx.common.data.Rating

data class Show(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val title: String?,
    @SerializedName("genres") val genres: List<String>?,
    @SerializedName("summary") val description: String?,
    @SerializedName("image") val image: Image?,
    @SerializedName("rating") val rating: Rating?,
    @SerializedName("schedule") val schedule: ShowSchedule?,
    @SerializedName("_embedded") val embedded: ShowEmbedded?,
)