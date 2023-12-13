package com.tasty.recipesapp.ui.recipe

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.tasty.recipesapp.data.dtos.input.InstructionDTO
import com.tasty.recipesapp.data.models.RecipeModel
import com.tasty.recipesapp.providers.RepositoryProvider
import kotlinx.coroutines.launch

object RecipeListViewModel : ViewModel() {

    private val _recipesModels = MutableLiveData<List<RecipeModel>>()
    val recipesModels: LiveData<List<RecipeModel>> = _recipesModels

    // Function to load data from the repository
    // Context should be removed
    fun loadRecipesData(context: Context) {

        viewModelScope.launch {
            val data = RepositoryProvider.recipesRepository.getAll(context)

            _recipesModels.postValue(data)
        }
    }
    fun getRecipeById(id : Int) : RecipeModel?{
        return _recipesModels.value?.find { it -> it.id == id }
    }

    fun getRecipeFromDbById(id: Long): RecipeModel? {
        var recipe : RecipeModel? = null
        viewModelScope.launch {

            recipe = RepositoryProvider.recipesRepository.getRecipeFromDbById(id)
        }

        return recipe
    }


    fun fetchRecipeInstructionsFromFile(){
        //Resources.getSystem().assets.open()
    }

}