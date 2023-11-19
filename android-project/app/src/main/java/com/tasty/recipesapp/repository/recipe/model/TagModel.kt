package com.tasty.recipesapp.repository.recipe.model

class TagModel (
    var root_tag_type: String?,
    var name: String?,
    var display_name: String?,
    var type: String?,
){
    override fun toString(): String {
        return "{root_tag_type=${this.root_tag_type}, name=${this.name}, display_name=${this.display_name}, type=${this.type}}"
    }
}
