package com.tasty.recipesapp.repository.recipe.model

class PriceModel (
    val consumption_portion: Long,
    val total: Long,
    val updated_at: String? = "Default updated_at",
    val portion: Long,
    val consumption_total: Long,
){
    override fun toString(): String {
        return "Price: ${this.total}$"
    }
}