package com.tasty.recipesapp.repository.recipe.model

fun TopicDTO.toModel(): TopicModel {
    return TopicModel(
        name = this.name,
        slug = this.slug
    )
}
