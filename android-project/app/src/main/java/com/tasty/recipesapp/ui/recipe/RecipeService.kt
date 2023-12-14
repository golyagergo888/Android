package com.tasty.recipesapp.ui.recipe

import com.tasty.recipesapp.data.models.RecipeModel
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RecipeService {
    @GET("recipes/list")
    @Headers(
        "X-RapidAPI-Key: 3a877daedbmsh36ef147d9a2b436p1f9433jsn5af968cbfdf7",
        "X-RapidAPI-Host: tasty.p.rapidapi.com"
    )
    suspend fun getRecipes(
        @Query("from") from: String,
        @Query("size") size: String,
        @Query("tags") tags: String? = null
    ): RecipeModel
}