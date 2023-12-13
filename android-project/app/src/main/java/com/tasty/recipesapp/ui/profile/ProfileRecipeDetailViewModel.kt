package com.tasty.recipesapp.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasty.recipesapp.data.models.RecipeModel
import com.tasty.recipesapp.providers.RepositoryProvider
import kotlinx.coroutines.launch

class ProfileRecipeDetailViewModel : ViewModel() {
    private val _recipeModel : MutableLiveData<RecipeModel?> = MutableLiveData<RecipeModel?>(null)
    val recipeModel : LiveData<RecipeModel?> = _recipeModel

    fun loadRecipeFromDbById(id: Long){
        viewModelScope.launch {

            _recipeModel.postValue(RepositoryProvider.recipesRepository.getRecipeFromDbById(id))
        }
    }


}