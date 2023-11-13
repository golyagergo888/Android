package com.tasty.recipesapp.repository.recipe.model

fun UserRatingsDTO.toModel(): UserRatingsModel {
    return UserRatingsModel(
        count_positive = this.count_positive,
        score = this.score,
        count_negative = this.count_negative
    )
}
