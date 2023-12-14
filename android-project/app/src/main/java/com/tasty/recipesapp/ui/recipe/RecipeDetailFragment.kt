package com.tasty.recipesapp.ui.recipe

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.os.Bundle
import android.net.Uri
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.squareup.picasso.Picasso
import com.tasty.recipesapp.R
import com.tasty.recipesapp.data.models.RecipeModel
import com.tasty.recipesapp.databinding.FragmentRecipeDetailBinding
import com.tasty.recipesapp.ui.profile.ProfileRecipeDetailViewModel

class RecipeDetailFragment : Fragment() {

    private lateinit var binding: FragmentRecipeDetailBinding

    private val recipeListViewModel: RecipeListViewModel by viewModels()

    private val profileRecipeViewModel: ProfileRecipeDetailViewModel by viewModels()

    private var recipe: RecipeModel? = null

    private var ingredients = mutableListOf<TextView>()

    private var instructions = mutableListOf<TextView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRecipeDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recipeId = arguments?.getInt("recipeId")

        val recipeType = arguments?.getString("recipeType")


        if (recipeId != null) {

            if (recipeType != null && recipeType == "Profile") {
                Log.d(TAG, "Profile")
                profileRecipeViewModel.loadRecipeFromDbById(recipeId.toLong())

                profileRecipeViewModel.recipeModel.observe(viewLifecycleOwner) { recipe ->
                    loadUi(recipe)
                }
            } else {
                Log.d(TAG, "Recipes")
                recipe = recipeListViewModel.getRecipeById(recipeId.toLong())!!

                loadUi(recipe)
            }

        }
    }

    private fun loadUi(recipe: RecipeModel?) {
        binding.recipeTitleView.text = recipe?.name
        binding.recipeDescriptionView.text = recipe?.description
        binding.detailInstructions.text = recipe?.getInstructionsList()
        binding.detailIngredients.text = recipe?.getRecipeIngredientsList()

        val thumbnailUrl = recipe?.thumbnailUrl
        if (thumbnailUrl != null) {
            if (thumbnailUrl.isNotEmpty()) {
                Picasso.get().load(thumbnailUrl).placeholder(R.drawable.ic_launcher_background)
                    .into(binding.recipeImageView)
            }
        }

        val originalVideoUrl = recipe?.original_video_url
        if (!originalVideoUrl.isNullOrEmpty()) {
            // Convert the video URL to a Uri
            val videoUri = Uri.parse(originalVideoUrl)

            // Set the video URI to the VideoView
            binding.videoView.setVideoURI(videoUri)

            // Create a MediaController to control the video playback
            val mediaController = MediaController(requireContext())
            mediaController.setAnchorView(binding.videoView)

            // Set the MediaController for the VideoView
            binding.videoView.setMediaController(mediaController)

            // Start playing the video
            binding.videoView.start()
        }

    }
}