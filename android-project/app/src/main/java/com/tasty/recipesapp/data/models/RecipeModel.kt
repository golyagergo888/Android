package com.tasty.recipesapp.data.models

data class RecipeModel (
    var id: Int,
    val name : String,
    val thumbnailUrl: String,
    val original_video_url: String?,
    val tags: List<TagModel>? = null,
    val userRatings: UserRatingsModel? = null,
    val sections: List<SectionModel>? = null,
    val nutrition: NutritionModel? = null,
    val topics: List<TopicModel>? = null,
    val instructions: List<InstructionModel>?,
    val credits: List<CreditModel>? = null,
    val createdAt: Long = 0,
    val price: PriceModel?,
    val description: String? = null,
    val cookTimeMinutes: Int? = null,
    val keywords: String? = null
){
    override fun toString(): String {
        return "{name=${this.name},\n description=${this.description},\n thumb_url=${this.thumbnailUrl},\n video_url = ${this.original_video_url},\n price=${this.price.toString()},\n nutrition=${this.nutrition.toString()},\n " +
                "credits=${this.credits.toString()},\n instructions=${this.instructions.toString()},\n sections=${this.sections.toString()},\n " +
                "tags=${this.tags.toString()},\n user_ratings=${this.userRatings.toString()},\n topics=${this.topics.toString()}\n}"
    }

    fun getInstructionsList(): String {
        val stringBuilder = StringBuilder()

        for ((index, instruction) in instructions?.withIndex()!!) {
            stringBuilder.append("${index + 1}. ${instruction.display_text}.\n")
        }

        return stringBuilder.toString()
    }

    fun getRecipeIngredientsList(): String {
        val stringBuilder = StringBuilder()

        stringBuilder.append("${sections?.get(0)?.getSectionIngredientsList()}\n")


        return stringBuilder.toString()
    }

    fun getPrice(): String {
        return price?.toString() ?:""
    }
}