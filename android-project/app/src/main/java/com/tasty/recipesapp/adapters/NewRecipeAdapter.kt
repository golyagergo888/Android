package com.tasty.recipesapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tasty.recipesapp.R
import com.tasty.recipesapp.data.models.RecipeModel
import com.tasty.recipesapp.databinding.RecipeListItemBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

interface OnItemClickListenerEntity {
    fun onItemClick(id: Long)
}

interface OnDeleteClickListener {
    fun onDeleteClick(id: Long)
}

class NewRecipeAdapter(
    val onClickListener: OnItemClickListenerEntity, val onDeleteClickListener: OnDeleteClickListener
) : RecyclerView.Adapter<NewRecipeAdapter.RecipeItemViewHolder>() {
    private var recipesList: MutableList<RecipeModel> = mutableListOf()

    fun setData(list: List<RecipeModel>?) {
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


    inner class RecipeItemViewHolder(private val binding: RecipeListItemBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        val recipeTitleView: TextView = binding.recipeTitleView
        val recipeDescriptionView: TextView = binding.recipeDescriptionView
        val recipeNutritionView: TextView = binding.recipeNutritionView
        val recipeRatingView: TextView = binding.ratingTextView
        val recipePriceView: TextView = binding.priceTextView
        val recipeImageView: ImageView = binding.recipeImageView

        init {
            binding.root.setOnClickListener {
                val position: Int = adapterPosition
                val currentPosition = this.bindingAdapterPosition
                val currentRecipe = recipesList[currentPosition]

                onClickListener.onItemClick(currentRecipe.id.toLong())
            }
        }

        override fun onClick(p0: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                onClickListener.onItemClick(recipesList[position].id.toLong())
            }
        }
    }

    override fun onBindViewHolder(holder: RecipeItemViewHolder, position: Int) {
        try {
            val currentRecipe = recipesList[position]
            holder.recipeTitleView.text = currentRecipe.name ?: "Default Name"
            holder.recipeDescriptionView.text = currentRecipe.description ?: "Default Description"
            // Bind other properties as needed
            holder.recipeNutritionView.text = currentRecipe.nutrition?.toString() ?: "No Nutrition"
            holder.recipeRatingView.text = currentRecipe.userRatings?.toString() ?: "No Rating"
            holder.recipePriceView.text = currentRecipe.price?.toString() ?: "No Price"

            val thumbnailUrl = currentRecipe.thumbnailUrl
            if (thumbnailUrl.isNotEmpty()) {
                Picasso.get().load(thumbnailUrl).placeholder(R.drawable.ic_launcher_background)
                    .into(holder.recipeImageView)
            }

            holder.itemView.setOnLongClickListener {
                onDeleteClickListener.onDeleteClick(recipesList[position].id.toLong())
                true
            }
        } catch (ex: Exception) {
            return
        }
    }

    override fun getItemCount(): Int {
        return recipesList.size
    }

    private fun formatDate(date: Date): String {
        val sdf = SimpleDateFormat("yyyy.MM.dd hh:mm", Locale.getDefault())
        return sdf.format(date)
    }
}