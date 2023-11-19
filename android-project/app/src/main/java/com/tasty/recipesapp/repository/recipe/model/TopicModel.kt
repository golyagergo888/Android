package com.tasty.recipesapp.repository.recipe.model

class TopicModel (
    val name: String?,
    val slug: String?
){
    override fun toString(): String {
        return "{name=${this.name}, slug=${this.slug}}"
    }
}
