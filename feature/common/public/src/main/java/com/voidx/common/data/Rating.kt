package com.voidx.common.data

import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("average") val average: Float
)