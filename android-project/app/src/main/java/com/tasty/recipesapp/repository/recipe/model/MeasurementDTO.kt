package com.tasty.recipesapp.repository.recipe.model

class MeasurementDTO (
    val unit: UnitDTO?,
    val quantity: String? = "Default quantity",
    val id: Long,
)
