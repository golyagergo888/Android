package com.tasty.recipesapp.ui.recipe.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tasty.recipesapp.repository.recipe.RecipeRepository
import com.tasty.recipesapp.repository.recipe.model.RecipeModel

class RecipeListViewModel : ViewModel() {
    private val repository = RecipeRepository

    // Live data
    var recipeList: MutableLiveData<List<RecipeModel>> = MutableLiveData()

    fun fetchRecipesData(context: Context) {
        recipeList.value = repository.getRecipes(context)
    }
}
