package com.tasty.recipesapp.repository.recipe.model

class RecipesDTO(
    val count: Int,
    val results: List<RecipeDTO>
)

fun RecipeDTO.toModel(): RecipeModel {
    return RecipeModel(
        name = this.name ?: "Default name",
        description = this.description ?: "Default description",
        nutrition = this.nutrition?.toModel(),
        credits = this.credits.map { it?.toModel() },
        instructions = this.instructions.map { it?.toModel() },
        sections = this.sections.map { it?.toModel() },
//        components = this.components.map { it?.toModel() } ?: emptyList1(),
        ingredient = this.ingredient?.toModel(),
//        measurements = this.measurements.map { it?.toModel() } ?: emptyList1(),
        unit = this.unit?.toModel(),
        tags = this.tags.map { it?.toModel() },
        user_ratings = this.user_ratings?.toModel(),
        topics = this.topics.map { it?.toModel() }
    )
}

fun List<RecipeDTO>.toModelList(): List<RecipeModel> {
    return this.map { it.toModel() }
}
