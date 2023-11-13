package com.tasty.recipesapp.repository.recipe.model

class UnitsDTO (
    val units: List<UnitDTO>
)

fun UnitDTO.toModel(): UnitModel {
    return UnitModel(
        display_singular = this.display_singular,
        display_plural = this.display_plural,
        abbreviation = this.abbreviation,
        system = this.system,
        name = this.name
    )
}

fun List<UnitDTO>.toModelList(): List<UnitModel> {
    return this.map {
        it.toModel()
    }
}
