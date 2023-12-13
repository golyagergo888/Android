package com.tasty.recipesapp.data.models

data class SectionModel (
    val position : Int,
    val components : List<ComponentModel>,
    val name : String?
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
