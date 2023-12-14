package com.tasty.recipesapp.data.dtos.input

data class RecipeResultDTO(
    val count: Int,
    val results: List<RecipeDTO>
)