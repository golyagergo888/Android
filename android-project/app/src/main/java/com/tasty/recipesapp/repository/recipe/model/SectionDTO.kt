package com.tasty.recipesapp.repository.recipe.model

import kotlin.collections.emptyList as emptyList1

class SectionDTO(
    val components: List<ComponentDTO?> = emptyList1(),
    val name: String?,
    val position: Long,
)
