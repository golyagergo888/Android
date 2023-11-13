package com.tasty.recipesapp.repository.recipe.model

class TopicsDTO (
    val name: String,
    val slug: String,
)

fun TopicDTO.toModel(): TopicModel {
    return TopicModel(
        name = this.name,
        slug = this.slug
    )
}

fun List<TopicDTO>.toModelList(): List<TopicModel> {
    return this.map {
        it.toModel()
    }
}
