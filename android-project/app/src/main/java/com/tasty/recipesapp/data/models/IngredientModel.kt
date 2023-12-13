package com.tasty.recipesapp.data.models
data class IngredientModel (
    val updated_at: Long,
    val name: String?,
    val created_at: Long,
    val id: Long,
){
    override fun toString(): String {
        return "{updated_at=${this.updated_at}, name=${this.name}, created_at=${this.created_at}}"
    }

    fun getIngredient(): String {
        return "${this.name}"
    }
}
