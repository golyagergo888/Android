package com.tasty.recipesapp.repository.recipe.model

class UserRatingsModel (
    val count_positive: Long,
    val score: Double,
    val count_negative: Long,
){
    override fun toString(): String {
        return "{count_positive=${this.count_positive}, score=${this.score}, count_negative=${this.count_negative}}"
    }
}
