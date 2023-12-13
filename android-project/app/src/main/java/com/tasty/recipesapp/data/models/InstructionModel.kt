package com.tasty.recipesapp.data.models

data class InstructionModel (
    val id: Long,
    val display_text: String?,
    val time: InstructionTime?
){
    override fun toString(): String {
        return "{id=${this.id}, display_text=${this.display_text}, time=${this.time}}"
    }
}

data class InstructionTime(
    val startTime: Int,
    val endTime: Int
)