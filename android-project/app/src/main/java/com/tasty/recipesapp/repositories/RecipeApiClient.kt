package com.tasty.recipesapp.repositories

import com.tasty.recipesapp.data.models.RecipeModel
import com.tasty.recipesapp.ui.recipe.RecipeService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RecipeApiClient {
    companion object {
        private const val BASE_URL = "https://tasty.p.rapidapi.com/"
    }

    private val recipeService: RecipeService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        recipeService = retrofit.create(RecipeService::class.java)
    }

    suspend fun getRecipes(from: String, size: String, tags: String?): RecipeModel? {
        return withContext(Dispatchers.IO) {
            try {
                recipeService.getRecipes(from, size, tags)
            } catch (e: Exception) {
                null
            }
        }
    }
}