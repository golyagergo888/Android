package com.tasty.recipesapp.ui.recipe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tasty.recipesapp.R
import com.tasty.recipesapp.adapters.OnItemClickListener
import com.tasty.recipesapp.adapters.RecipesListAdapter
import com.tasty.recipesapp.data.models.RecipeModel
import com.tasty.recipesapp.databinding.FragmentRecipesBinding

class RecipeFragment : Fragment(), OnItemClickListener {

    private val recipeListViewModel : RecipeListViewModel by viewModels()

    private lateinit var binding: FragmentRecipesBinding
    private val adapter: RecipesListAdapter = RecipesListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecipesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recipeRecyclerView = binding.recyclerView

        recipeRecyclerView.adapter = adapter

        recipeListViewModel.loadRecipesData(requireContext())

        recipeListViewModel.recipesModels.observe(viewLifecycleOwner) {  recipes ->

            adapter.setData(recipes)
        }

        recipeRecyclerView.layoutManager = LinearLayoutManager(this.context)
    }

    private fun navigateToRecipeDetail(recipe: RecipeModel) {

        findNavController()
            .navigate(R.id.action_recipesFragment_to_recipeDetailFragment,
                bundleOf("recipeId" to recipe.id, "recipeType" to "Recipe")
            )
    }

    override fun onItemClick(item: RecipeModel) {
        navigateToRecipeDetail(item)
    }
}