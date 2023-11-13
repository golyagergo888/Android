package com.tasty.recipesapp.repository.recipe.model

import kotlin.collections.emptyList as emptyList1

fun SectionDTO.toModel(): SectionModel {
    return SectionModel(
        components = this.components.map { it?.toModel() } ?: emptyList1(),
        name = this.name,
        position = this.position
    )
}
