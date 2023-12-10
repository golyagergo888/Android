package com.tasty.recipesapp.repository.recipe.model

class SectionModel (
    val components: List<ComponentModel?> = emptyList(),
    val name: String?,
    val position: Long
){
    override fun toString(): String {
        return "{components=${this.components}, name=${this.name}, position=${this.position}}"
    }

    fun getSectionIngredientsList(): String {
        val stringBuilder = StringBuilder()

        for ((index, component) in components.withIndex()) {
            stringBuilder.append("${index + 1}. ${component?.ingredient?.getIngredient()}.\n")
        }

        return stringBuilder.toString()
    }
}
