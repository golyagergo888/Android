package com.tasty.recipesapp.repository.recipe.model

class RecipeModel(
    val name: String?,
    val description: String?,
    val thumbnail_url: String?,
    val original_video_url: String?,
    val price: PriceModel?,
    val nutrition: NutritionModel?,
    val credits: List<CreditModel?> = emptyList(),
    val instructions: List<InstructionModel?>,
    val sections: List<SectionModel?> = emptyList(),
    val tags: List<TagModel?> = emptyList(),
    val user_ratings: UserRatingsModel?,
    val topics: List<TopicModel?>
) {
    override fun toString(): String {
        return "{name=${this.name},\n description=${this.description},\n thumb_url=${this.thumbnail_url},\n video_url = ${this.original_video_url},\n price=${this.price.toString()},\n nutrition=${this.nutrition.toString()},\n " +
                "credits=${this.credits.toString()},\n instructions=${this.instructions.toString()},\n sections=${this.sections.toString()},\n " +
                "tags=${this.tags.toString()},\n user_ratings=${this.user_ratings.toString()},\n topics=${this.topics.toString()}\n}"
    }
}
