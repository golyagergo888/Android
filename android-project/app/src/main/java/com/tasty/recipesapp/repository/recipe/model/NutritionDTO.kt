package com.tasty.recipesapp.repository.recipe.model

data class NutritionDTO(
    val calories: Long,
    val sugar: Long,
    val carbohydrates: Long,
    val fiber: Long,
    val updated_at: String? = "Default updated_at",
    val protein: Long,
    val fat: Long,
)
