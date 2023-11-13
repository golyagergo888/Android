package com.tasty.recipesapp.repository.recipe.model

class SectionsDTO(
    val sections: List<SectionDTO>
)

fun SectionDTO.toModel(): SectionModel {
    return SectionModel(
        components = this.components.toModelList(),
        name = this.name,
        position = this.position
    )
}

fun List<SectionDTO>.toModelList(): List<SectionModel> {
    return this.map {
        it.toModel()
    }
}
