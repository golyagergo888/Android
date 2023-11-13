package com.tasty.recipesapp.repository.recipe.model

class RecipesDTO(
    val count: Int,
    val results: List<RecipeDTO>
)

fun RecipeDTO.toModel(): RecipeModel {
    return RecipeModel(
        name = name,
        description = description
    )
}
fun List<RecipeDTO>.toModelList(): List<RecipeModel> {
    return map {
        it.toModel()
    }
}
