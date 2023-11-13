package com.tasty.recipesapp.repository.recipe.model

class ComponentModel (
    val extra_comment: String?,
    val ingredient: IngredientModel?,
    val id: Long,
    val position: Long,
    val measurements: List<MeasurementModel?>?,
    val raw_text: String?,
)
