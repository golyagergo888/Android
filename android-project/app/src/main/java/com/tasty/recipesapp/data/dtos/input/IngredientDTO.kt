package com.tasty.recipesapp.data.dtos.input

import com.google.gson.annotations.SerializedName

data class IngredientDTO (
    @SerializedName("updated_at")
    val updatedAt : Int,
    val name : String,
    @SerializedName("created_at")
    val createdAt: Int,
    @SerializedName("display_plural")
    val displayPlural: String,
    val id : Int,
    @SerializedName("display_singular")
    val displaySingular : String
)