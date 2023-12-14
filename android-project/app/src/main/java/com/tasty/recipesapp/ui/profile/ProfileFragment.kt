package com.tasty.recipesapp.ui.profile

import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tasty.recipesapp.R
import com.tasty.recipesapp.adapters.NewRecipeAdapter
import com.tasty.recipesapp.adapters.OnDeleteClickListener
import com.tasty.recipesapp.adapters.OnItemClickListenerEntity
import com.tasty.recipesapp.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(), OnItemClickListenerEntity, OnDeleteClickListener {

    private lateinit var binding: FragmentProfileBinding

    private val profileRecipeListViewModel : ProfileRecipeListViewModel by viewModels()

    private val adapter: NewRecipeAdapter = NewRecipeAdapter(this, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentProfileBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recipeRecyclerView = binding.recyclerView

        recipeRecyclerView.adapter = adapter

        profileRecipeListViewModel.loadAllRecipesFromDb()

        profileRecipeListViewModel.recipeModels.observe(viewLifecycleOwner) {  recipes ->
            adapter.setData(recipes)
        }

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_newRecipeFragment)
        }

        recipeRecyclerView.layoutManager = LinearLayoutManager(this.context)

    }

    override fun onItemClick(id: Long) {
        val bundle = Bundle()

        Log.d(TAG, "CLICKED")

        bundle.putInt("recipeId",id.toInt())
        bundle.putString("recipeType", "Profile")

        findNavController()
            .navigate(
                R.id.action_profileFragment_to_recipeDetailFragment,
                bundle
            )
    }

    override fun onDeleteClick(id: Long) {
        val alertDialogBuilder = AlertDialog.Builder(requireContext())
        alertDialogBuilder.apply {
            setTitle("Recept törlése")
            setMessage("Biztosan törölni szeretné ezt a receptet?")
            setPositiveButton("Igen") { _, _ ->
                profileRecipeListViewModel.deleteRecipeById(id)
            }
            setNegativeButton("Mégsem") { dialog, _ ->
                dialog.dismiss()
            }
        }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}