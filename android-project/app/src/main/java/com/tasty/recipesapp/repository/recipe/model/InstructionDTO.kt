package com.tasty.recipesapp.repository.recipe.model

class InstructionDTO (
    val appliance: String? = "Default appliance",
    val end_time: Int,
    val temperature: String? = "Default temperature",
    val id: Int,
    val position: Int,
    val display_text: String? = "Default display_text",
    val start_time: Int
)
