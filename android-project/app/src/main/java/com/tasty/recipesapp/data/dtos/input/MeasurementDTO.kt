package com.tasty.recipesapp.data.dtos.input

data class MeasurementDTO (
    val unit : UnitDTO,
    val quantity : String,
    val id: Int
)