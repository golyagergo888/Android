package com.tasty.recipesapp.repository.recipe.model

class ComponentModel (
    val extra_comment: String?,
    val ingredient: IngredientModel?,
    val id: Long,
    val position: Long,
    val measurements: List<MeasurementModel?>?,
    val raw_text: String?,
){
    override fun toString(): String {
        return "{extra_comment=${this.extra_comment}, ingredient=${this.ingredient}, id=${this.id}, position=${this.position}, measurements=${this.measurements}, raw_text=${this.raw_text}}"
    }
}
