package com.tasty.recipesapp.repository.recipe.model

fun InstructionDTO.toModel(): InstructionModel {
    return InstructionModel(
        id = this.id.toLong(),
        display_text = this.display_text?: "Default display_text",
        time = InstructionTime(
            start_time = this.start_time,
            end_time = this.end_time
        )
    )
}
