package com.tasty.recipesapp.repository.recipe

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tasty.recipesapp.repository.recipe.model.RecipeModel
import com.tasty.recipesapp.repository.recipe.model.RecipesDTO
import com.tasty.recipesapp.repository.recipe.model.toModelList
import java.io.IOException

object RecipeRepository {
    private val TAG: String? = RecipeRepository::class.java.canonicalName
    private var recipesList: List<RecipeModel> = emptyList()
    private var myRecipeList: ArrayList<RecipeModel> = ArrayList()

    fun getRecipes(context: Context): List<RecipeModel> {
        lateinit var jsonString: String
        try {
            jsonString =
                context.assets.open("all_recipes.json").bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            Log.e(TAG, "Error occurred while reading JSON file: ${ioException.message}")
            return emptyList()
        }
        val recipesResponse: RecipesDTO =
            Gson().fromJson(jsonString, object : TypeToken<RecipesDTO>() {}.type)

        recipesList = recipesResponse.results.toModelList()

        return recipesList
    }

    fun insertRecipe(recipeEntity: RecipeModel): Boolean {
        Log.d(TAG,"insertRecipe - called()")
        Log.d(TAG,"Recipe Entity: name: ${recipeEntity.name} desc: ${recipeEntity.description}")
        val res=myRecipeList.add(recipeEntity)
        Log.d(TAG,"$res")
        Log.d(TAG,"My Recipe List size: ${myRecipeList.size}")

        return  res
    }

    fun deleteRecipe(recipeEntity: RecipeModel): Boolean {
        Log.d(TAG, "AAAA RECIPE3: ${recipeEntity.toString()}")
        return myRecipeList.remove(recipeEntity)
    }

    fun getMyRecipes():ArrayList<RecipeModel> {
        Log.d(TAG,"getMyRecipes - called()")
        Log.d(TAG,"My Recipe List size: ${myRecipeList.size}")

        return myRecipeList
    }

    fun getRecipeDetailById(recipeId: Long): RecipeModel?{
        return recipesList.find { it.id == recipeId }
    }
}