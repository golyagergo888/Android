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
) {
    override fun toString(): String {
        return "{name=${this.name},\n description=${this.description},\n nutrition=${this.nutrition.toString()},\n " +
                "credits=${this.credits.toString()},\n instructions=${this.instructions.toString()},\n sections=${this.sections.toString()},\n " +
                "components=${this.components.toString()},\n ingredient=${this.ingredient.toString()},\n measurements=${this.measurements.toString()},\n " +
                "unit=${this.unit.toString()},\n tags=${this.tags.toString()},\n user_ratings=${this.user_ratings.toString()},\n topics=${this.topics.toString()}\n}"
    }
}
