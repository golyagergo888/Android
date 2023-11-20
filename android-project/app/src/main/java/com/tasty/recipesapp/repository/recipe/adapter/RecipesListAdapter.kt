package com.tasty.recipesapp.repository.recipe.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tasty.recipesapp.databinding.ActivityMainBinding
import com.tasty.recipesapp.databinding.RecipeListItemBinding
import com.tasty.recipesapp.repository.recipe.model.RecipeModel
import com.squareup.picasso.Picasso;

class RecipesListAdapter(
    private var recipesList: List<RecipeModel>,
    private val context: Context
) : RecyclerView.Adapter<RecipesListAdapter.RecipeItemViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecipeItemViewHolder {
        val binding = RecipeListItemBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return RecipeItemViewHolder(binding)
    }

    override fun getItemCount(): Int = recipesList.size

    inner class RecipeItemViewHolder(binding: RecipeListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val recipeTitleView: TextView = binding.recipeTitleView
        val recipeDescriptionView: TextView = binding.recipeDescriptionView
        val recipeNutritionView: TextView = binding.recipeNutritionView
        val recipeRatingView: TextView = binding.recipeRatingView
        val recipeImageView: ImageView = binding.recipeImageView
    }

    override fun onBindViewHolder(holder: RecipeItemViewHolder, position: Int) {
        val currentRecipe = recipesList[position]
        holder.recipeTitleView.text = currentRecipe.name ?: "Default Name"
        holder.recipeDescriptionView.text = currentRecipe.description ?: "Default Description"
        // Bind other properties as needed
        holder.recipeNutritionView.text = currentRecipe.nutrition?.toString() ?: "No Nutrition"
        holder.recipeRatingView.text = currentRecipe.user_ratings?.toString() ?: "No Rating"

        val thumbnailUrl = currentRecipe.thumbnail_url
        if (thumbnailUrl != null && thumbnailUrl.isNotEmpty()) {
            Picasso.get().load(thumbnailUrl).into(holder.recipeImageView)
        }
    }
}