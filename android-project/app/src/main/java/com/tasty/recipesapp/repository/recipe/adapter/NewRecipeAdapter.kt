package com.tasty.recipesapp.repository.recipe.adapter
import android.content.ContentValues
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tasty.recipesapp.R
import com.tasty.recipesapp.databinding.RecipeListItemBinding
import com.tasty.recipesapp.repository.recipe.model.RecipeModel

class NewRecipeAdapter(
    private var recipesList: List<RecipeModel>,
    private val onRecipeLongClicked: (RecipeModel) -> Unit,
) : RecyclerView.Adapter<NewRecipeAdapter.RecipeItemViewHolder>() {

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
            }
        }
    }

    override fun onBindViewHolder(holder: RecipeItemViewHolder, position: Int) {
        val currentRecipe = recipesList[position]
        holder.recipeTitleView.text = currentRecipe.name ?: "Default Name"
        holder.recipeDescriptionView.text = currentRecipe.description ?: "Default Description"
        // Bind other properties as needed
        holder.recipeNutritionView.text = currentRecipe.nutrition?.toString() ?: "No Nutrition"
        holder.recipeRatingView.text = currentRecipe.user_ratings?.toString() ?: "No Rating"
        holder.recipePriceView.text = currentRecipe.price?.toString() ?: "No Price"

        val thumbnailUrl = currentRecipe.thumbnail_url
        if (!thumbnailUrl.isNullOrEmpty()) {
            Picasso.get().load(thumbnailUrl).placeholder(R.drawable.ic_launcher_background)
                .into(holder.recipeImageView)
        }

        holder.itemView.setOnLongClickListener{
            onRecipeLongClicked.invoke(currentRecipe)
            true
        }
    }

    fun updateData(newData: List<RecipeModel>) {
        recipesList = newData
        notifyDataSetChanged()
    }

}