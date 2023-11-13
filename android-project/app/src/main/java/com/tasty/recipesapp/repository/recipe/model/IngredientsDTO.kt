package com.tasty.recipesapp.repository.recipe.model

fun IngredientDTO.toModel(): IngredientModel {
    return IngredientModel(
        updated_at = this.updated_at,
        name = this.name?: "Default name",
        created_at = this.created_at,
        display_plural = this.display_plural?: "Default display_plural",
        id = this.id,
        display_singular = this.display_singular?: "Default display_singular",
    )
}
