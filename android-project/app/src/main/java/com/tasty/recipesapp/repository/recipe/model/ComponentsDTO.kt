package com.tasty.recipesapp.repository.recipe.model

class ComponentsDTO(
    val components: List<ComponentDTO>
)

fun ComponentDTO.toModel(): ComponentModel {
    return ComponentModel(
        raw_text = this.raw_text,
        ingredient = this.ingredient.toModel(),
        id = this.id,
        position = this.position,
        measurements = this.measurements.toModelList(),
        extra_comment = this.extra_comment
        )
}

fun List<ComponentDTO>.toModelList(): List<ComponentModel> {
    return this.map {
        it.toModel()
    }
}
