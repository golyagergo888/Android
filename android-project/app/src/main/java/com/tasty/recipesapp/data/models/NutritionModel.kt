package com.tasty.recipesapp.data.models

data class NutritionModel (
    val fiber : Int,
    val protein : Int,
    val fat : Int,
    val calories : Int,
    val sugar : Int,
    val carbohydrates : Int
){
    override fun toString(): String {
        return "calories: ${this.calories}\nsugar: ${this.sugar}\ncarbohydrates: ${this.carbohydrates}\n" +
                "fiber: ${this.fiber}\nprotein: ${this.protein}\nfat: ${this.fat}"

    }
}