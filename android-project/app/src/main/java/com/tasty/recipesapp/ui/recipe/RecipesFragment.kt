package com.tasty.recipesapp.ui.recipe

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tasty.recipesapp.R
import com.tasty.recipesapp.repository.recipe.adapter.RecipesListAdapter
import com.tasty.recipesapp.ui.recipe.viewmodel.RecipeListViewModel

class RecipesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this)[RecipeListViewModel::class.java]

        context?.let {
            viewModel.fetchRecipesData(it)
        }

        viewModel.recipeList.observe(viewLifecycleOwner) { recipes ->
            for (recipe in recipes) {
                Log.d(TAG, "Recipe: ${recipe.toString()}" )
                Log.d(TAG, "-------------------------------------------" )
            }
            // Create adapter
            val adapter = RecipesListAdapter(recipes, requireContext())

            // Setup recycler view
            val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(context) // Use the appropriate layout manager

            // Set adapter to recycler view
            recyclerView.adapter = adapter
        }


    }
}
