package com.tasty.recipesapp.data.dtos.input

data class SectionDTO (
    val position : Int,
    val components : List<ComponentDTO>,
    val name : String?
)