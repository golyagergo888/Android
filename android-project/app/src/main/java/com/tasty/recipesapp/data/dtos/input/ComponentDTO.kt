package com.tasty.recipesapp.data.dtos.input

import com.google.gson.annotations.SerializedName

data class ComponentDTO (
    val position : Int,
    @SerializedName("raw_text")
    val rawText : String,
    @SerializedName("extra_comment")
    val extraComment : String,
    val ingredient : IngredientDTO,
    val id: Int
)