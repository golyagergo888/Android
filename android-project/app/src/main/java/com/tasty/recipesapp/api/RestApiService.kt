package com.tasty.recipesapp.api

import com.tasty.recipesapp.data.dtos.input.RecipeDTO
import com.tasty.recipesapp.data.dtos.input.RecipeResultDTO
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RestApiService {
    @GET("recipes/list")
    @Headers(
        "X-RapidAPI-Key: 3a877daedbmsh36ef147d9a2b436p1f9433jsn5af968cbfdf7",
        "X-RapidAPI-Host: tasty.p.rapidapi.com"
    )
    suspend fun getRecipes(
        @Query("from") from: String,
        @Query("size") size: String,
        @Query("tags") tags: String? = null,
        @Query("sort") sort: String? = null
    ): RecipeResultDTO

    @GET("recipes/get-more-info")
    @Headers(
        "X-RapidAPI-Key: 3a877daedbmsh36ef147d9a2b436p1f9433jsn5af968cbfdf7",
        "X-RapidAPI-Host: tasty.p.rapidapi.com"
    )
    suspend fun getRecipeDetail(
        @Query("id") id: String,

        ): RecipeDTO
}