package com.tasty.recipesapp.repository.recipe.model

data class InstructionsDTO (
    val instructions: List<InstructionDTO>
)
fun InstructionDTO.toModel(): InstructionModel {
    return InstructionModel(
        id = this.id,
        display_text = this.display_text,
        time = InstructionTime(
            start_time = this.start_time,
            end_time = this.end_time
        )
    )
}

fun List<InstructionDTO>.toModelList(): List<InstructionModel> {
    return this.map { it.toModel() }
}
