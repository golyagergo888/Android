package com.tasty.recipesapp.utils

import com.tasty.recipesapp.data.dtos.input.ComponentDTO
import com.tasty.recipesapp.data.dtos.input.CreditDTO
import com.tasty.recipesapp.data.dtos.input.IngredientDTO
import com.tasty.recipesapp.data.dtos.input.InstructionDTO
import com.tasty.recipesapp.data.dtos.input.MeasurementDTO
import com.tasty.recipesapp.data.dtos.input.NutritionDTO
import com.tasty.recipesapp.data.dtos.input.PriceDTO
import com.tasty.recipesapp.data.dtos.input.SectionDTO
import com.tasty.recipesapp.data.dtos.input.TagDTO
import com.tasty.recipesapp.data.dtos.input.TopicDTO
import com.tasty.recipesapp.data.dtos.input.UnitDTO
import com.tasty.recipesapp.data.dtos.input.UserRatingsDTO
import com.tasty.recipesapp.data.models.ComponentModel
import com.tasty.recipesapp.data.models.CreditModel
import com.tasty.recipesapp.data.models.IngredientModel
import com.tasty.recipesapp.data.models.InstructionModel
import com.tasty.recipesapp.data.models.InstructionTime
import com.tasty.recipesapp.data.models.MeasurementModel
import com.tasty.recipesapp.data.models.NutritionModel
import com.tasty.recipesapp.data.models.PriceModel
import com.tasty.recipesapp.data.models.SectionModel
import com.tasty.recipesapp.data.models.TagModel
import com.tasty.recipesapp.data.models.TopicModel
import com.tasty.recipesapp.data.models.UnitModel
import com.tasty.recipesapp.data.models.UserRatingsModel

fun UserRatingsDTO.toModel() : UserRatingsModel {
    return UserRatingsModel(
        countPositive = this.countPositive,
        countNegative = this.countNegative,
        score = this.score
    )
}

fun UnitDTO.toModel() : UnitModel {
    return UnitModel(
        system = this.system,
        name = this.name
    )
}

fun PriceDTO.toModel() : PriceModel {
    return PriceModel(
        consumption_portion = this.consumption_portion.toLong(),
        total = this.total.toLong(),
        updated_at = this.updated_at,
        portion = this.portion.toLong(),
        consumption_total = this.consumption_total.toLong()
    )
}

fun TopicDTO.toModel() : TopicModel {
    return TopicModel(
        name = this.name,
        slug = this.slug
    )
}

fun List<TopicDTO>.toModel() : List<TopicModel> {
    return this.map { it.toModel() }
}

fun TagModel.toModel() : TagModel{
    return TagModel(
        rootTagType = this.rootTagType,
        name = this.name,
        id = this.id,
        displayName = this.displayName,
        type = this.type
    )
}

fun IngredientDTO.toModel() : IngredientModel {
    return IngredientModel(
        updated_at = this.updatedAt.toLong(),
        name = this.name,
        created_at = this.createdAt.toLong(),
        id = this.id.toLong()
    )
}

fun ComponentDTO.toModel() : ComponentModel {
    return ComponentModel(
        position = this.position.toLong(),
        raw_text = this.rawText,
        id = this.id.toLong(),
        ingredient = this.ingredient.toModel(),
        extra_comment = this.extraComment
    )
}

fun SectionDTO.toModel() : SectionModel {
    return SectionModel(
        position = this.position,
        name = this.name,
        components = this.components.map { it.toModel() }
    )
}

fun NutritionDTO.toModel() : NutritionModel {
    return NutritionModel(
        fiber = this.fiber,
        protein = this.protein,
        fat = this.fat,
        calories = this.calories,
        sugar = this.sugar,
        carbohydrates = this.carbohydrates
    )
}

fun MeasurementDTO.toModel() : MeasurementModel {
    return MeasurementModel(
        unit = this.unit.toModel(),
        quantity = this.quantity,
        id = this.id
    )
}
fun InstructionDTO.toModel() : InstructionModel{
    return InstructionModel(
        id = this.id.toLong(),
        display_text = this.displayText,
        time = InstructionTime(this.startTime, this.endTime)
    )
}

fun CreditDTO.toModel() : CreditModel {
    return CreditModel(
        name = this.name,
        type = this.type
    )
}

fun TagDTO.toModel() : TagModel{
    return TagModel(
        rootTagType = this.rootTagType,
        name = this.name,
        id = this.id,
        displayName = this.displayName,
        type = this.type
    )
}