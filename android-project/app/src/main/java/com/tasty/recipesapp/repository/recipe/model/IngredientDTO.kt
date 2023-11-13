package com.tasty.recipesapp.repository.recipe.model

class IngredientDTO (
    val updated_at: Long,
    val name: String? = "Default name",
    val created_at: Long,
    val display_plural: String? = "Default display_plural",
    val id: Long,
    val display_singular: String? = "Default display_singular",
)
