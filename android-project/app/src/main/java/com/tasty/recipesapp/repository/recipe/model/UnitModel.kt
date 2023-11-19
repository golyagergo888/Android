package com.tasty.recipesapp.repository.recipe.model

class UnitModel(
    val system: String?,
    val name: String?,
) {
    override fun toString(): String {
        return "{system=${this.system}, name=${this.name}}"
    }
}