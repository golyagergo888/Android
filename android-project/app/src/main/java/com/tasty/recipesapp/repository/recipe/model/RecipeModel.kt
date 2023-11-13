package com.tasty.recipesapp.repository.recipe.model

class RecipeModel(
    val name: String?,
    val description: String?,
    val nutrition: NutritionModel?,
    val credits: List<CreditModel?> = emptyList(),
    val instructions: List<InstructionModel?>,
    val sections: List<SectionModel?> = emptyList(),
    val components: List<ComponentModel?> = emptyList(),
    val ingredient: IngredientModel?,
    val measurements: List<MeasurementModel?> = emptyList(),
    val unit: UnitModel?,
    val tags: List<TagModel?> = emptyList(),
    val user_ratings: UserRatingsModel?,
    val topics: List<TopicModel?>
)