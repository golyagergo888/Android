package com.tasty.recipesapp.repository.recipe.model

class InstructionModel(
    val appliance: String?,
    val temperature: String?,
    val id: Int,
    val display_text: String?,
    val time: InstructionTime?
)

class InstructionTime(
    val start_time: Int,
    val end_time: Int
)
