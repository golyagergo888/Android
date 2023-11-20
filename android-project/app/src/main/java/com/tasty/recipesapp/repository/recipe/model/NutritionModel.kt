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
        return "calories: ${this.calories}\n sugar: ${this.sugar}\n carbohydrates: ${this.carbohydrates}\n" +
                "fiber: ${this.fiber}\n protein: ${this.protein}\n fat: ${this.fat}"

    }
}

