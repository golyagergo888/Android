package com.tasty.recipesapp.utils

import com.tasty.recipesapp.data.dtos.input.ComponentDTO
import com.tasty.recipesapp.data.dtos.input.CreditDTO
import com.tasty.recipesapp.data.dtos.input.IngredientDTO
import com.tasty.recipesapp.data.dtos.input.InstructionDTO
import com.tasty.recipesapp.data.dtos.input.MeasurementDTO
import com.tasty.recipesapp.data.dtos.input.NutritionDTO
import com.tasty.recipesapp.data.dtos.input.PriceDTO
import com.tasty.recipesapp.data.dtos.input.RecipeDTO
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
import com.tasty.recipesapp.data.models.RecipeModel
import com.tasty.recipesapp.data.models.SectionModel
import com.tasty.recipesapp.data.models.TagModel
import com.tasty.recipesapp.data.models.TopicModel
import com.tasty.recipesapp.data.models.UnitModel
import com.tasty.recipesapp.data.models.UserRatingsModel

object Mapping {

    fun UserRatingsDTO2Model(userRatingsDTO: UserRatingsDTO) : UserRatingsModel {
        return UserRatingsModel(
            countPositive = userRatingsDTO.countPositive,
            countNegative = userRatingsDTO.countNegative,
            score = userRatingsDTO.score
        )
    }

    fun UnitDTO2Model(unitDTO: UnitDTO) : UnitModel {
        return UnitModel(
            system = unitDTO.system,
            name = unitDTO.name
        )
    }

    fun PriceDTO2Model(priceDTO: PriceDTO) : PriceModel {
        return PriceModel(

            consumption_portion = priceDTO.consumption_portion,
            total = priceDTO.total,
            updated_at = priceDTO.updated_at,
            portion = priceDTO.portion,
            consumption_total = priceDTO.consumption_total

        )
    }

    fun TopicDTO2Model(topicDTO: TopicDTO) : TopicModel {
        return TopicModel(
            name = topicDTO.name,
            slug = topicDTO.slug
        )
    }

    fun TagDTO2toModel(tagDTO: TagDTO) : TagModel{
        return TagModel(
            rootTagType = tagDTO.rootTagType,
            name = tagDTO.name,
            id = tagDTO.id,
            displayName = tagDTO.displayName,
            type = tagDTO.type
        )
    }

    fun IngredientDTO2Model(ingredientDTO: IngredientDTO) : IngredientModel {
        return IngredientModel(
            updated_at = ingredientDTO.updatedAt.toLong(),
            name = ingredientDTO.name,
            created_at = ingredientDTO.createdAt.toLong(),
            id = ingredientDTO.id.toLong()
        )
    }

    fun ComponentDTO2toModel(componentDTO: ComponentDTO) : ComponentModel {
        return ComponentModel(
            position = componentDTO.position.toLong(),
            raw_text = componentDTO.rawText,
            id = componentDTO.id.toLong(),
            ingredient = IngredientDTO2Model(componentDTO.ingredient),
            extra_comment = componentDTO.extraComment,
        )
    }

    fun SectionDTO2Model(sectionDTO: SectionDTO) : SectionModel {
        return SectionModel(
            position = sectionDTO.position,
            name = sectionDTO.name,
            components = sectionDTO.components.map { ComponentDTO2toModel(it) }
        )
    }

    fun NutritionDTO2Model(nutritionDTO: NutritionDTO) : NutritionModel {
        return NutritionModel(
            fiber = nutritionDTO.fiber,
            protein = nutritionDTO.protein,
            fat = nutritionDTO.fat,
            calories = nutritionDTO.calories,
            sugar = nutritionDTO.sugar,
            carbohydrates = nutritionDTO.carbohydrates
        )
    }

    fun MeasurementDTO2Model(measurementDTO: MeasurementDTO) : MeasurementModel {
        return MeasurementModel(
            unit = UnitDTO2Model(measurementDTO.unit),
            quantity = measurementDTO.quantity,
            id = measurementDTO.id
        )
    }

    fun InstructionDTO2Model(instructionDTO: InstructionDTO) : InstructionModel{
        return InstructionModel(
            id = instructionDTO.id.toLong(),
            display_text = instructionDTO.displayText,
            time = InstructionTime(instructionDTO.startTime, instructionDTO.endTime)
        )
    }

    fun CreditDTO2Model(creditDTO: CreditDTO) : CreditModel {
        return CreditModel(
            name = creditDTO.name,
            type = creditDTO.type
        )
    }

    fun TagDTO2Model(tagDTO: TagDTO) : TagModel{
        return TagModel(
            rootTagType = tagDTO.rootTagType,
            name = tagDTO.name,
            id = tagDTO.id,
            displayName = tagDTO.displayName,
            type = tagDTO.type
        )
    }


    fun RecipeDTO2Model(recipeDTO: RecipeDTO) : RecipeModel {
        return RecipeModel(
            id = recipeDTO.id,
            name = recipeDTO.name,
            thumbnailUrl = recipeDTO.thumbnailUrl,
            original_video_url = recipeDTO.original_video_url,
            price = PriceDTO2Model(recipeDTO.price),
            tags = recipeDTO.tags.map { TagDTO2toModel(it) },
            userRatings = UserRatingsDTO2Model(recipeDTO.userRatings),
            sections = recipeDTO.sections.map { SectionDTO2Model(it) },
            nutrition = NutritionDTO2Model(recipeDTO.nutrition),
            topics =  recipeDTO.topics.map { TopicDTO2Model(it) },
            instructions = recipeDTO.instructions.map { InstructionDTO2Model(it) },
            credits = recipeDTO.credits.map { CreditDTO2Model(it) },
            createdAt = recipeDTO.createdAt.toLong(),
            description = recipeDTO.description,
            cookTimeMinutes = recipeDTO.cookTimeMinutes,
            keywords = recipeDTO.keywords
        )
    }



}