package com.tasty.recipesapp.repository.recipe.model

data class RecipeDTO(
    val id: Int,
    val name: String,
    val description: String?,
    val aspect_ratio: String = "default",
    val nutrition: NutritionDTO,
    val credits: CreditDTO,
    val instructions: List<InstructionDTO>,
    val sections: List<SectionDTO>,
    val components: List<ComponentDTO>,
    val tags: List<TagDTO>,
    val topics: List<TopicDTO>,
    val userRatings: UserRatingsDTO
)
