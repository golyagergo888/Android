package com.tasty.recipesapp.repository.recipe.model

class NutritionModel(
    val calories: Long,
    val sugar: Long,
    val carbohydrates: Long,
    val fiber: Long,
    val updated_at: String?,
    val protein: Long,
    val fat: Long,
) {
    override fun toString(): String {
        return "calories=${this.calories}, sugar=${this.sugar}, carbohydrates=${this.carbohydrates}, " +
                "fiber=${this.fiber}, updated_at=${this.updated_at}, protein=${this.protein}, " +
                "fat=${this.fat}"
    }
}

