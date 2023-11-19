package com.tasty.recipesapp.repository.recipe.model

fun UnitDTO.toModel(): UnitModel {
    return UnitModel(
        system = this.system,
        name = this.name
    )
}