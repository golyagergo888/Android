package com.tasty.recipesapp.repository.recipe.model

import kotlin.collections.emptyList as emptyList1

data class RecipeDTO(
    val id: Long,
    val name: String? = "Default name",
    val description: String? = "Default description",
    val thumbnail_url: String? = "Default thumbnail_url",
    val original_video_url: String? = "Default original_video_url",
    val price: PriceDTO?,
    val nutrition: NutritionDTO? = null,
    val credits: List<CreditDTO?> = emptyList1(),
    val instructions: List<InstructionDTO?> = emptyList1(),
    val sections: List<SectionDTO?> = emptyList1(),
    val tags: List<TagDTO?> = emptyList1(),
    val user_ratings: UserRatingsDTO?,
    val topics: List<TopicDTO?>,
    val cookTimeMinutes: Int? = null,
)
