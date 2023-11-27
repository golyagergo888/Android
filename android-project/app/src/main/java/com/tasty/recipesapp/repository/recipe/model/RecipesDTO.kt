package com.tasty.recipesapp.repository.recipe.model

class RecipesDTO(
    val count: Int,
    val results: List<RecipeDTO>
)

fun RecipeDTO.toModel(): RecipeModel {
    return RecipeModel(
        id = this.id,
        name = this.name ?: "Default name",
        description = this.description ?: "Default description",
        thumbnail_url = this.thumbnail_url ?: "Default thumbnail_url",
        original_video_url = this.original_video_url ?: "Default original_video_url",
        price = this.price?.toModel(),
        nutrition = this.nutrition?.toModel(),
        credits = this.credits.map { it?.toModel() },
        instructions = this.instructions.map { it?.toModel() },
        sections = this.sections.map { it?.toModel() },
        tags = this.tags.map { it?.toModel() },
        user_ratings = this.user_ratings?.toModel(),
        topics = this.topics.map { it?.toModel() }
    )
}

fun List<RecipeDTO>.toModelList(): List<RecipeModel> {
    return this.map { it.toModel() }
}
