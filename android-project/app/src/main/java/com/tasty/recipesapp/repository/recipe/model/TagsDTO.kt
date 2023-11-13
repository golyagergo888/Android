package com.tasty.recipesapp.repository.recipe.model

fun TagDTO.toModel(): TagModel {
    return TagModel(
        root_tag_type = this.root_tag_type,
        name = this.name,
        display_name = this.display_name,
        type = this.type
    )
}
