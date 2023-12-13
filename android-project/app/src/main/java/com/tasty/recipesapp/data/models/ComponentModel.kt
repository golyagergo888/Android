package com.tasty.recipesapp.data.models
data class ComponentModel (
    val position: Long,
    val raw_text: String?,
    val ingredient: IngredientModel?,
    val id: Long,
    val extra_comment: String?,
    val measurements: List<MeasurementModel?> = emptyList(),

){
    override fun toString(): String {
        return "{extra_comment=${this.extra_comment}, ingredient=${this.ingredient}, id=${this.id}, position=${this.position}, measurements=${this.measurements}, raw_text=${this.raw_text}}"
    }
}
