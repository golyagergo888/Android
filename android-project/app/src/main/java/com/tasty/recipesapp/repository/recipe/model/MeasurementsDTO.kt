package com.tasty.recipesapp.repository.recipe.model

class MeasurementsDTO (
    val measurements: List<MeasurementDTO>
)

fun MeasurementDTO.toModel(): MeasurementModel {
    return MeasurementModel(
        unit = this.unit.toModel(),
        quantity = this.quantity,
        id = this.id
    )
}

fun List<MeasurementDTO>.toModelList(): List<MeasurementModel> {
    return this.map {
        it.toModel()
    }
}
