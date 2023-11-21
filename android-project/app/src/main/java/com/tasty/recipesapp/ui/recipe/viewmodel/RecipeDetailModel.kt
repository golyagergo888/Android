package com.tasty.recipesapp.ui.recipe.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tasty.recipesapp.repository.recipe.RecipeRepository
import com.tasty.recipesapp.repository.recipe.model.RecipeModel

class RecipeDetailModel : ViewModel() {
    private val repository = RecipeRepository

    // Live data
    var recipeDetail: MutableLiveData<RecipeModel> = MutableLiveData()

//    fun fetchRecipeData(context: Context) {
//        recipeDetail.value = repository.getRecipes(context)
//    }
}
