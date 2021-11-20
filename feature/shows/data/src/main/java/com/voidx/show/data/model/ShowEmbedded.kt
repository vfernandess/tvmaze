package com.voidx.show.data.model

import com.google.gson.annotations.SerializedName
import com.voidx.episode.data.model.Episode

data class ShowEmbedded(
    @SerializedName("episodes") val episodes: List<Episode>,
)