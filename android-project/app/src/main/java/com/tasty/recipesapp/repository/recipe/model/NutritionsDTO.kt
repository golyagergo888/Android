package com.tasty.recipesapp.repository.recipe.model

fun NutritionDTO.toModel(): NutritionModel {
    return NutritionModel(
        sugar = this.sugar,
        carbohydrates = this.carbohydrates,
        fiber = this.fiber,
        updated_at = this.updated_at,
        protein = this.protein,
        fat = this.fat,
        calories = this.calories
    )
}
