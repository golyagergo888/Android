package com.tasty.recipesapp.adapters

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tasty.recipesapp.databinding.RecipeListItemBinding
import com.squareup.picasso.Picasso;
import com.tasty.recipesapp.R
import com.tasty.recipesapp.data.models.RecipeModel

interface OnItemClickListener {
    fun onItemClick(item: RecipeModel)
}

class RecipesListAdapter(val onClickListener: OnItemClickListener) :
    RecyclerView.Adapter<RecipesListAdapter.RecipeItemViewHolder>() {

    private var recipesList: MutableList<RecipeModel> = mutableListOf();

    fun setData(list: List<RecipeModel>?){
        recipesList.clear()
        recipesList.addAll(list!!)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecipeItemViewHolder {
        val binding = RecipeListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return RecipeItemViewHolder(binding)
    }

    override fun getItemCount(): Int = recipesList.size

    inner class RecipeItemViewHolder(binding: RecipeListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val recipeTitleView: TextView = binding.recipeTitleView
        val recipeDescriptionView: TextView = binding.recipeDescriptionView
        val recipeNutritionView: TextView = binding.recipeNutritionView
        val recipeRatingView: TextView = binding.ratingTextView
        val recipePriceView: TextView = binding.priceTextView
        val recipeImageView: ImageView = binding.recipeImageView

        init {
            binding.root.setOnClickListener {
                val currentPosition = this.bindingAdapterPosition
                val currentRecipe = recipesList[currentPosition]

                onClickListener.onItemClick(currentRecipe)
            }
        }
    }

    override fun onBindViewHolder(holder: RecipeItemViewHolder, position: Int) {
        val currentRecipe = recipesList[position]
        holder.recipeTitleView.text = currentRecipe.name ?: "Default Name"
        holder.recipeDescriptionView.text = currentRecipe.description ?: "Default Description"
        // Bind other properties as needed
        holder.recipeNutritionView.text = currentRecipe.nutrition?.toString() ?: "No Nutrition"
        holder.recipeRatingView.text = currentRecipe.userRatings?.toString() ?: "No Rating"
        holder.recipePriceView.text = currentRecipe.price?.toString() ?: "No Price"

        val thumbnailUrl = currentRecipe.thumbnailUrl
        if (thumbnailUrl.isNotEmpty()) {
            Log.d(TAG, "AAAthumbnailUrl: $thumbnailUrl")
            Picasso.get().load(thumbnailUrl).placeholder(R.drawable.ic_launcher_background)
                .into(holder.recipeImageView)
        }

    }
}
