package com.tasty.recipesapp.repository.recipe.model

class NutritionsDTO (
    val sugar: Long,
    val carbohydrates: Long,
    val fiber: Long,
    val updated_at: String,
    val protein: Long,
    val fat: Long,
    val calories: Long,
)

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

fun List<NutritionDTO>.toModelList(): List<NutritionModel> {
    return this.map {
        it.toModel()
    }
}
