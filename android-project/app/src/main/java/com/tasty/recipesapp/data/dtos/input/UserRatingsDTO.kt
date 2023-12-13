package com.tasty.recipesapp.data.dtos.input

import com.google.gson.annotations.SerializedName

data class UserRatingsDTO (
    @SerializedName("count_positive")
    val countPositive : Int,
    @SerializedName("count_negative")
    val countNegative : Int,
    val score : Double
)