package com.tasty.recipesapp.repository.recipe.model

class CreditModel (
    val name: String?,
    val type: String?
){
    override fun toString(): String {
        return "{name=${this.name}, type=${this.type}}"
    }
}
