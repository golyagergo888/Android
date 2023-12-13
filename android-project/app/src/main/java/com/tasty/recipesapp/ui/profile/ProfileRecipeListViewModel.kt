package com.tasty.recipesapp.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasty.recipesapp.data.models.RecipeModel
import com.tasty.recipesapp.providers.RepositoryProvider
import kotlinx.coroutines.launch

object ProfileRecipeListViewModel : ViewModel() {
    
    private val _recipeModels = MutableLiveData<List<RecipeModel>>()
    val recipeModels: LiveData<List<RecipeModel>> = _recipeModels

    fun loadAllRecipesFromDb() {
        viewModelScope.launch {
            val data = RepositoryProvider.recipesRepository.getRecipeFromLocalDb()

            _recipeModels.postValue( data)
        }
    }

    fun getRecipeById(id: Long): RecipeModel?{
        return _recipeModels.value?.first{ it.id.toLong() == id}
    }

    fun getRecipeByIdFromDb(id: Long): RecipeModel? {

        var recipe : RecipeModel? = null
        viewModelScope.launch {
            recipe = RepositoryProvider.recipesRepository.getRecipeFromDbById(id)
        }
        return recipe
    }

    fun deleteRecipeById(id : Long){
        viewModelScope.launch {

            RepositoryProvider.recipesRepository.deleteRecipeFromDb(id)

            val updatedList = _recipeModels.value?.toMutableList()
            updatedList?.removeAll { it.id == id.toInt() }
            _recipeModels.postValue(updatedList!!)
        }
    }
}