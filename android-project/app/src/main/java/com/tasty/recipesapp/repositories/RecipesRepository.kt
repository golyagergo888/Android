package com.tasty.recipesapp.repositories

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import com.tasty.recipesapp.data.dtos.input.RecipeDTO
import com.tasty.recipesapp.data.models.RecipeModel
import com.tasty.recipesapp.database.daos.RecipeDao
import com.tasty.recipesapp.database.entities.RecipeEntity
import com.tasty.recipesapp.utils.toModel
import kotlinx.coroutines.withContext
import java.io.IOException

// Csomag importálása a kotlin.collections csomagból
import kotlinx.coroutines.Dispatchers
import org.json.JSONObject

// Csomag importálása a com.google.gson.reflect csomagból
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RecipesRepository(private val recipeDao: RecipeDao) : IGenericRepository<RecipeDTO, RecipeModel> {

    val gson = Gson()

    override fun RecipeDTO.toModel(): RecipeModel {
        return RecipeModel(
            id = this.id,
            name = this.name,
            thumbnailUrl = this.thumbnailUrl,
            original_video_url = this.original_video_url,
            price = this.price.toModel(),
            tags = this.tags.map{ it.toModel()},
            userRatings = this.userRatings.toModel(),
            sections = this.sections.map { it.toModel() },
            nutrition = this.nutrition.toModel(),
            topics = this.topics.toModel(),
            instructions = this.instructions.map { it.toModel()},
            credits = this.credits.map { it.toModel() },
            createdAt = this.createdAt.toLong(),
            description = this.description,
            cookTimeMinutes = this.cookTimeMinutes,
            keywords = this.keywords
        )
    }

    override fun List<RecipeDTO>.toModelList(): List<RecipeModel> {
        return this.map { it.toModel() }
    }

    override suspend fun getAll(context: Context): List<RecipeModel> {
        return readAll(context).toModelList()
    }

    override suspend fun readAll(context: Context): List<RecipeDTO> {
        var recipeList = listOf<RecipeDTO>()
        val assetManager = context.assets

        try {
            val inputStream = assetManager.open("all_recipes.json")
            val size = withContext(Dispatchers.IO) {
                inputStream.available()
            }
            val buffer = ByteArray(size)
            withContext(Dispatchers.IO) {
                inputStream.read(buffer)
            }
            withContext(Dispatchers.IO) {
                inputStream.close()
            }
            val jsonString = String(buffer, Charsets.UTF_8)

            //If there is an extra label
            val jsonObject = JSONObject(jsonString)
            val recipesArray = jsonObject.getJSONArray("results")

            val type = object : TypeToken<List<RecipeDTO>>() {}.type
            recipeList = gson.fromJson(recipesArray.toString(), type)
            //instructions.value = instructionList
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return recipeList
    }

    suspend fun getRecipeFromLocalDb(): List<RecipeModel> {
        val dataEntities = recipeDao.getAllRecipes()

        return dataEntities.map { recipeEntityToModel(it) }
    }

    suspend fun getRecipeFromDbById(id : Long): RecipeModel? {
        val dataEntity = recipeDao.getRecipeById(id)

        if(dataEntity != null){
            return recipeEntityToModel(dataEntity)
        }

        return null
    }

    suspend fun deleteRecipeFromDb(id : Long){
        return recipeDao.deleteRecipeById(id)
    }

    suspend fun insertRecipe(recipeEntity: RecipeEntity){
        return recipeDao.insertRecipe(recipeEntity)
    }

    private fun recipeEntityToModel(dataEntity: RecipeEntity): RecipeModel{

        val recipe  = gson.fromJson(dataEntity.json, RecipeModel::class.java)

        recipe!!.id = dataEntity.internalId.toInt()

        return recipe
    }
}

