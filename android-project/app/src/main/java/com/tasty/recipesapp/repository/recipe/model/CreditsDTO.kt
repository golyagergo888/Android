package com.tasty.recipesapp.repository.recipe.model

data class CreditsDTO (
    val credits: List<CreditDTO>
)
fun CreditDTO.toModel(): CreditModel {
    return CreditModel(
        name = this.name,
        type = this.type
    )
}

fun List<CreditDTO>.toModelList(): List<CreditModel> {
    return this.map {
        it.toModel()
    }
}
