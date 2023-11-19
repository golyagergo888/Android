package com.tasty.recipesapp.repository.recipe.model

import kotlin.collections.emptyList as emptyList1

fun PriceDTO.toModel(): PriceModel {
    return PriceModel(
        consumption_portion = this.consumption_portion,
        total = this.total,
        updated_at = this.updated_at,
        portion = this.portion,
        consumption_total = this.consumption_total
    )
}