package com.tasty.recipesapp.repository.recipe.model

class UserRatingsModel (
    val count_positive: Long,
    val score: Double,
    val count_negative: Long,
){
    override fun toString(): String {
        return "Rating= ${String.format("%.2f", this.score * 100)}%"
    }
}
