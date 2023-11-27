package com.tasty.recipesapp.ui.recipe

import android.content.ContentValues.TAG
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import com.tasty.recipesapp.R
import com.tasty.recipesapp.databinding.FragmentRecipeDetailBinding
import com.tasty.recipesapp.repository.recipe.adapter.RecipesListAdapter
import com.tasty.recipesapp.ui.recipe.viewmodel.RecipeDetailViewModel

class RecipeDetailFragment : Fragment() {
    private lateinit var binding: FragmentRecipeDetailBinding

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

        val viewModel = ViewModelProvider(this)[RecipeDetailViewModel::class.java]

        val recipeId = arguments?.getLong("recipeId") ?: 0

        context.let {
            viewModel.fetchRecipeDetailData(recipeId)
            Log.d(TAG, "RecipeId: $recipeId")
        }

        viewModel.recipeDetail.observe(viewLifecycleOwner) { recipe ->
            Log.d(TAG, "Recipe: ${recipe.toString()}")
            Log.d(TAG, "-------------------------------------------")

            binding.recipeTitleView.text = recipe?.name
            binding.recipeDescriptionView.text = recipe?.description

            val thumbnailUrl = recipe.thumbnail_url
            if (!thumbnailUrl.isNullOrEmpty()) {
//                Log.d(TAG, "AAAthumbnailUrl: $thumbnailUrl")
                Picasso.get().load(thumbnailUrl).placeholder(R.drawable.ic_launcher_background)
                    .into(binding.recipeImageView)
            }

            val originalVideoUrl = recipe.original_video_url
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
}
