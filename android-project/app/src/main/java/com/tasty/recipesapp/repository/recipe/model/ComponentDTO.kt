package com.tasty.recipesapp.repository.recipe.model

class ComponentDTO(
    val extra_comment: String?,
    val ingredient: IngredientDTO?,
    val id: Long,
    val position: Long,
    val measurements: List<MeasurementDTO?>?,
    val raw_text: String?,
)
