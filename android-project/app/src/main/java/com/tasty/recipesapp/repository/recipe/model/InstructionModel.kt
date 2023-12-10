package com.tasty.recipesapp.repository.recipe.model

class InstructionModel(
    val id: Long,
    val display_text: String?,
    val time: InstructionTime?
){
    override fun toString(): String {
        return "{id=${this.id}, display_text=${this.display_text}, time=${this.time}}"
    }
}

class InstructionTime(
    val start_time: Int,
    val end_time: Int
)
