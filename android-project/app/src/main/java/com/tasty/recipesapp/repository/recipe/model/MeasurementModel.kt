package com.tasty.recipesapp.repository.recipe.model

class MeasurementModel (
    val unit: UnitModel?,
    val quantity: String?,
){
    override fun toString(): String {
        return "{unit=${this.unit}, quantity=${this.quantity}}"
    }
}
