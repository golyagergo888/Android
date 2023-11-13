package com.tasty.recipesapp.repository.recipe.model

class RecipeModel (
    val name: String,
    val description: String?,
    val nutrition: NutritionModel,
    val credits: List<CreditModel>,
    val instructions: List<InstructionModel>,
    val sections: List<SectionModel>,
    val components: List<ComponentModel>,
    val tags: List<TagModel>,
    val topics: List<TopicModel>,
    val userRatings: UserRatingsModel
)
