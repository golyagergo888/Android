package com.tasty.recipesapp.ui.recipe

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tasty.recipesapp.R
import com.tasty.recipesapp.databinding.FragmentRecipeDetailBinding
import com.tasty.recipesapp.databinding.FragmentRecipesBinding
import com.tasty.recipesapp.repository.recipe.adapter.RecipesListAdapter
import com.tasty.recipesapp.repository.recipe.model.RecipeModel
import com.tasty.recipesapp.ui.recipe.viewmodel.RecipeListViewModel

class RecipesFragment : Fragment() {
    private lateinit var recipesAdapter: RecipesListAdapter
    private lateinit var binding: FragmentRecipesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRecipesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this)[RecipeListViewModel::class.java]

        viewModel.recipeList.observe(viewLifecycleOwner) { recipes ->
            for (recipe in recipes) {
                Log.d(TAG, "Recipe: ${recipe.toString()}")
                Log.d(TAG, "-------------------------------------------")
            }
            // Create adapter
            val adapter = RecipesListAdapter(
                recipes,
                requireContext(),
                onItemClick = { navigateToRecipeDetail(it) })

            // Setup recycler view
            val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
            recyclerView.layoutManager =
                LinearLayoutManager(context) // Use the appropriate layout manager

            // Set adapter to recycler view
            recyclerView.adapter = adapter
        }

        context?.let {
            viewModel.fetchRecipesData(it)
        }
    }

    private fun navigateToRecipeDetail(recipe: RecipeModel) {
        findNavController()
            .navigate(
                R.id.action_recipesFragment_to_recipeDetailFragment,
                bundleOf("recipeId" to recipe.id)
            )
    }
}
