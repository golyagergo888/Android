package com.tasty.recipesapp.ui.recipe.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tasty.recipesapp.repository.recipe.RecipeRepository
import com.tasty.recipesapp.repository.recipe.model.RecipeModel

class RecipeDetailViewModel : ViewModel() {
    private val repository = RecipeRepository

    // Live data
    var recipeDetail: MutableLiveData<RecipeModel> = MutableLiveData()

    fun fetchRecipeDetailData(recipeId: Long) {
//        recipeDetail.value = repository.getRecipes(context)
        recipeDetail.value = repository.getRecipeDetailById(recipeId)
    }
}
