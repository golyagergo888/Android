package com.tasty.recipesapp.repository.recipe.model

class SectionModel (
    val components: List<ComponentModel?> = emptyList(),
    val name: String?,
    val position: Long
){
    override fun toString(): String {
        return "{components=${this.components}, name=${this.name}, position=${this.position}}"
    }
}
