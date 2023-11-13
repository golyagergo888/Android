package com.tasty.recipesapp.repository.recipe.model

import kotlin.collections.emptyList as emptyList1

data class RecipeDTO(
    val id: Int,
    val name: String? = "Default name",
    val description: String? = "Default description",
    val nutrition: NutritionDTO? = null,
    val credits: List<CreditDTO?> = emptyList1(),
    val instructions: List<InstructionDTO?> = emptyList1(),
    val sections: List<SectionDTO?> = emptyList1(),
    val components: List<ComponentDTO?> = emptyList1(),
    val ingredient: IngredientDTO?,
    val measurements: List<MeasurementDTO?> = emptyList1(),
    val unit: UnitDTO?,
    val tags: List<TagDTO?> = emptyList1(),
    val user_ratings: UserRatingsDTO?,
    val topics: List<TopicDTO?>
)
