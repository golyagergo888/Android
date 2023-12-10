package com.tasty.recipesapp.ui.profile

import android.app.AlertDialog
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.tasty.recipesapp.R
import com.tasty.recipesapp.databinding.FragmentProfileBinding
import com.tasty.recipesapp.repository.profile.viewmodel.ProfileViewModel
import com.tasty.recipesapp.repository.recipe.adapter.NewRecipeAdapter
import com.tasty.recipesapp.repository.recipe.adapter.RecipesListAdapter
import com.tasty.recipesapp.repository.recipe.model.RecipeModel
import com.tasty.recipesapp.ui.recipe.NewRecipeFragment
import com.tasty.recipesapp.ui.recipe.viewmodel.RecipeListViewModel
import kotlinx.coroutines.launch

class ProfileFragment : Fragment() {
    private lateinit var profileViewModel: ProfileViewModel
    private lateinit var recipesAdapter: NewRecipeAdapter
    private lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        profileViewModel = context?.let { ProfileViewModel() }!!

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]

        viewModel.recipeList.observe(viewLifecycleOwner) { recipes ->
            for (recipe in recipes) {
                Log.d(TAG, "Recipe: ${recipe.toString()}")
                Log.d(TAG, "-------------------------------------------")
            }
            // Create adapter
            val recipesAdapter = NewRecipeAdapter(
                recipes,
                onRecipeLongClicked = { recipe ->
                    confirmDeleteRecipe(recipe)
                })

            // Setup recycler view
            val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
            recyclerView.layoutManager =
                LinearLayoutManager(context) // Use the appropriate layout manager

            // Set adapter to recycler view
            Log.d(TAG, "Set adapter to recycler view")
            recyclerView.adapter = recipesAdapter

            viewLifecycleOwner.lifecycleScope.launch {
                profileViewModel.fetchRecipesData(requireContext())
            }

            profileViewModel.recipeList.observe(viewLifecycleOwner) { recipes -> recipesAdapter.updateData(recipes) }
        }

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_newRecipeFragment)
        }

        context?.let {
            viewModel.fetchRecipesData(it)
        }
    }

    private fun confirmDeleteRecipe(recipe: RecipeModel) {
        val alertDialogBuilder = AlertDialog.Builder(requireContext())
        alertDialogBuilder.apply {
            setTitle("Recept törlése")
            setMessage("Biztosan törölni szeretné ezt a receptet?")
            setPositiveButton("Igen") { _, _ ->
                deleteRecipe(recipe)
            }
            setNegativeButton("Mégsem") { dialog, _ ->
                dialog.dismiss()
            }
        }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    private fun deleteRecipe(recipe: RecipeModel) {
        viewLifecycleOwner.lifecycleScope.launch {
            profileViewModel.removeRecipe(recipe)
            profileViewModel.fetchRecipesData(requireContext())
        }
    }
}