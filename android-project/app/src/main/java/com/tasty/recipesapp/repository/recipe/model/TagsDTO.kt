package com.tasty.recipesapp.repository.recipe.model

class TagsDTO(
    val tags: List<TagDTO>
)

fun TagDTO.toModel(): TagModel {
    return TagModel(
        root_tag_type = this.root_tag_type,
        name = this.name,
        id = this.id,
        display_name = this.display_name,
        type = this.type
    )
}

fun List<TagDTO>.toModelList(): List<TagModel> {
    return this.map {
        it.toModel()
    }
}
