package com.tasty.recipesapp.repository.profile.viewmodel

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasty.recipesapp.repository.recipe.RecipeRepository
import com.tasty.recipesapp.repository.recipe.model.RecipeModel
import kotlinx.coroutines.launch

class ProfileViewModel() : ViewModel() {
    private val repository = RecipeRepository

    // Live data
    var recipeList: MutableLiveData<List<RecipeModel>> = MutableLiveData()

    fun fetchRecipesData(context: Context) {
        recipeList.value = repository.getMyRecipes()
    }

    // Function to insert a recipe
    fun insertRecipe(recipe: RecipeModel) {
        viewModelScope.launch {
            repository.insertRecipe(recipe)
        }
    }

    // Function to remove a recipe
    fun removeRecipe(recipe: RecipeModel) {
        viewModelScope.launch {
            Log.d(TAG, "AAAA RECIPE1: ${recipe.toString()}")
            repository.deleteRecipe(recipe)
            recipeList.value = repository.getMyRecipes()
            Log.d(TAG, "AAAA RECIPE2: ${recipe.toString()}")

        }
    }
}