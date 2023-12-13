package com.tasty.recipesapp.data.dtos.input

import com.google.gson.annotations.SerializedName

data class UnitDTO (
    val system: String,
    val name: String,
    @SerializedName("display_plural")
    val displayPlural: String,
    @SerializedName("display_singular")
    val displaySingular: String,
    val abbreviation: String)