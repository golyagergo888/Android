package com.tasty.recipesapp.repository.recipe.model

fun InstructionDTO.toModel(): InstructionModel {
    return InstructionModel(
        id = this.id,
        display_text = this.display_text?: "Default display_text",
        appliance = this.appliance?: "Default appliance",
        temperature = this.temperature?: "Default temperature",
        time = InstructionTime(
            start_time = this.start_time,
            end_time = this.end_time
        )
    )
}
