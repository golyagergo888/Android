package com.tasty.recipesapp.providers

import android.content.Context
import com.tasty.recipesapp.database.RecipeDatabase
import com.tasty.recipesapp.database.daos.RecipeDao
import com.tasty.recipesapp.repositories.RecipesRepository

object  RepositoryProvider {

    private lateinit var recipeDao: RecipeDao

    fun initialize(context: Context) {
        recipeDao = RecipeDatabase.getDatabase(context).recipeDao()
    }

    private fun checkInitialized() {
        if (!::recipeDao.isInitialized) {
            throw UninitializedPropertyAccessException("RepositoryProvider has not been initialized")
        }
    }

    val recipesRepository: RecipesRepository by lazy {
        checkInitialized()
        RecipesRepository(recipeDao)
    }

}