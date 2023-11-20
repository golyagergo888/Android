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
        return "calories: ${this.calories}\nsugar: ${this.sugar}\ncarbohydrates: ${this.carbohydrates}\n" +
                "fiber: ${this.fiber}\nprotein: ${this.protein}\nfat: ${this.fat}"

    }
}

