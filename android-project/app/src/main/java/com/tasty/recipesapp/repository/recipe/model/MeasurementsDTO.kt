package com.tasty.recipesapp.repository.recipe.model

fun MeasurementDTO.toModel(): MeasurementModel {
    return MeasurementModel(
        unit = this.unit?.toModel(),
        quantity = this.quantity,
    )
}
