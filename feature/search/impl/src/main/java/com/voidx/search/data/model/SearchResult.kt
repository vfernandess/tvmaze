package com.voidx.search.data.model

import com.google.gson.annotations.SerializedName
import com.voidx.show.data.model.Show

data class SearchResult(
    @SerializedName("show") val show: Show?
)