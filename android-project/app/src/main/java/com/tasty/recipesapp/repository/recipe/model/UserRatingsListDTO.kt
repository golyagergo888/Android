package com.tasty.recipesapp.repository.recipe.model

class UserRatingsListDTO(
    val ratings: List<UserRatingsDTO>
)

fun UserRatingsDTO.toModel(): UserRatingsModel {
    return UserRatingsModel(
        count_positive = this.count_positive,
        score = this.score,
        count_negative = this.count_negative
    )
}

fun List<UserRatingsDTO>.toModelList(): List<UserRatingsModel> {
    return this.map {
        it.toModel()
    }
}
