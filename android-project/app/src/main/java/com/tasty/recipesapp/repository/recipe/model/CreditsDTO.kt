package com.tasty.recipesapp.repository.recipe.model

fun CreditDTO.toModel(): CreditModel {
    return CreditModel(
        name = this.name,
        type = this.type
    )
}
