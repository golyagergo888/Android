package com.tasty.recipesapp.data.models

import com.google.gson.annotations.SerializedName

data class UserRatingsModel (
    val countPositive : Int,
    val countNegative : Int,
    val score : Double
)