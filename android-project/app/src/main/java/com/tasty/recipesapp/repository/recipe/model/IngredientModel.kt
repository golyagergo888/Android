package com.tasty.recipesapp.repository.recipe.model

class IngredientModel(
    val updated_at: Long,
    val name: String?,
    val created_at: Long,
    val display_plural: String,
    val id: Long,
    val display_singular: String,
){
    override fun toString(): String {
        return "{updated_at=${this.updated_at}, name=${this.name}, created_at=${this.created_at}, display_plural=${this.display_plural}, id=${this.id}, display_singular=${this.display_singular}}"
    }

    fun getIngredient(): String {
        return "${this.name}"
    }
}
