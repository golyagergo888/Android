package com.tasty.recipesapp.data.dtos.input

import com.google.gson.annotations.SerializedName

data class RecipeDTO (
    val id: Int,
    val name : String,
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String,
    val original_video_url: String,
    val price: PriceDTO,
    val tags: List<TagDTO>,
    @SerializedName("user_ratings")
    val userRatings: UserRatingsDTO,
    val sections: List<SectionDTO>,
    val nutrition: NutritionDTO,
    val topics: List<TopicDTO>,
    val instructions: List<InstructionDTO>,
    val credits: List<CreditDTO>,
    @SerializedName("created_at")
    val createdAt: Int,
    val description: String,
    @SerializedName("cook_time_minutes")
    val cookTimeMinutes: Int?,
    @SerializedName("is_shoppable")
    val isShoppable: Boolean,
    val keywords: String?
)