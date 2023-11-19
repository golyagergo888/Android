package com.tasty.recipesapp.repository.recipe.model

class PriceModel (
    val consumption_portion: Long,
    val total: Long,
    val updated_at: String? = "Default updated_at",
    val portion: Long,
    val consumption_total: Long,
){
    override fun toString(): String {
        return "{consumption_portion=${this.consumption_portion}, total=${this.total}, updated_at=${this.updated_at}" +
                ", portion=${this.portion}, consumption_total=${this.consumption_total}}"
    }
}