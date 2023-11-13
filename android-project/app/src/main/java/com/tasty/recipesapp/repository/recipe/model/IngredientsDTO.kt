package com.tasty.recipesapp.repository.recipe.model

class IngredientsDTO (
    val ingredients: List<IngredientDTO>
)

fun IngredientDTO.toModel(): IngredientModel {
    return IngredientModel(
        updated_at = this.updated_at,
        name = this.name,
        created_at = this.created_at,
        display_plural = this.display_plural,
        id = this.id,
        display_singular = this.display_singular
    )
}

fun List<IngredientDTO>.toModelList(): List<IngredientModel> {
    return this.map {
        it.toModel()
    }
}
