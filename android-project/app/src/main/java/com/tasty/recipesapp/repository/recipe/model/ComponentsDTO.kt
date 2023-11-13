package com.tasty.recipesapp.repository.recipe.model

fun ComponentDTO.toModel(): ComponentModel {
    return ComponentModel(
        raw_text = this.raw_text?: "",
        ingredient = this.ingredient?.toModel(),
        id = this.id,
        position = this.position,
        measurements = this.measurements?.map { it?.toModel() } ?: emptyList(),
        extra_comment = this.extra_comment?: "",
        )
}
