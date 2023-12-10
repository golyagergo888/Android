package com.tasty.recipesapp.ui.recipe

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.tasty.recipesapp.R  // Adjust the package name accordingly
import com.tasty.recipesapp.databinding.FragmentNewRecipeBinding
import com.tasty.recipesapp.repository.profile.viewmodel.ProfileViewModel
import com.tasty.recipesapp.repository.recipe.model.ComponentModel
import com.tasty.recipesapp.repository.recipe.model.IngredientModel
import com.tasty.recipesapp.repository.recipe.model.InstructionModel
import com.tasty.recipesapp.repository.recipe.model.InstructionTime
import com.tasty.recipesapp.repository.recipe.model.RecipeModel
import com.tasty.recipesapp.repository.recipe.model.SectionModel
import kotlinx.coroutines.launch

class NewRecipeFragment : Fragment() {
    private lateinit var binding: FragmentNewRecipeBinding;
    private var ingredients = mutableListOf<EditText>()
    private var instructions = mutableListOf<EditText>()
    private lateinit var profileViewModel: ProfileViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewRecipeBinding.inflate(inflater, container, false)

        profileViewModel = context?.let { ProfileViewModel() }!!

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addIngredientsButton.setOnClickListener {
            addNewIngredient()
        }

        binding.addInstructionButton.setOnClickListener {
            addNewInstruction()
        }

        binding.saveRecipeButton.setOnClickListener {
            saveNewRecipe()
        }
    }

    private fun addNewIngredient() {
        val newEditText = EditText(requireContext())

        newEditText.hint = "#${ingredients.size + 1} Ingredient"

        newEditText.layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )

        ingredients.add(newEditText)

        binding.ingredientsLayout.addView(newEditText)

    }

    private fun addNewInstruction() {
        val newEditText = EditText(requireContext())

        newEditText.hint = "#${instructions.size + 1} Instruction"

        newEditText.layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )

        instructions.add(newEditText)

        binding.addInstructionLayout.addView(newEditText)
    }

    private fun saveNewRecipe() {
        if (binding.recipeTitle.text.toString().isEmpty()) {
            binding.recipeTitle.hint = "Title is Required!"
            return
        }

        if (binding.recipeCookTime.text.toString().isEmpty()) {
            binding.recipeCookTime.hint = "Cook Time is required!"
            return
        }


        val title = binding.recipeTitle.text.toString()
        val thumbnailUrl = binding.recipePictureUrl.text.toString()
        val description = binding.recipeDescription.text.toString()

        val cookTime = binding.recipeCookTime.text.toString().toInt()

        val timeNow = System.currentTimeMillis()

        val sections = mutableListOf<SectionModel>()

        val components = mutableListOf<ComponentModel>()

        ingredients.forEach { ing ->
            if (ing.text.toString().isNotEmpty()) {

                val ingredient =
                    IngredientModel(
                        timeNow.toLong(),
                        ing.text.toString(),
                        timeNow.toLong(),
                        "display_plural",
                        0,
                        "display_singular"
                    )

                components.add(ComponentModel(null, ingredient, 0, 0, emptyList(), null))
            }
        }

        val instructionList = mutableListOf<InstructionModel>()

        var instructionCounter = 0

        instructions.forEach { ins ->
            if (ins.text.toString().isNotEmpty()) {
                instructionCounter++

                instructionList.add(
                    InstructionModel(
                        instructionCounter.toLong(),
                        ins.text.toString(),
                        InstructionTime(
                            0, 0
                        )
                    )
                )
            }
        }

        sections.add(SectionModel(components, "Comp", 0))

        val newRecipe = RecipeModel(
            0,
            title,
            thumbnailUrl,
            description,
            null,
            null,
            null,
            sections = sections,
            instructions = instructionList,
            tags = emptyList(),
            user_ratings = null,
            topics = emptyList(),
            cook_time_minutes = cookTime,
        )

        context?.let { profileViewModel.insertRecipe(newRecipe) }
        Toast.makeText(requireContext(), "Recipe saved", Toast.LENGTH_SHORT).show()
        Log.d("Recipe", newRecipe.toString())

        binding.recipeTitle.text.clear()
        binding.recipePictureUrl.text.clear()
        binding.recipeDescription.text.clear()
        binding.recipeCookTime.text.clear()

        ingredients.clear()
        instructions.clear()

        findNavController().navigate(R.id.action_newRecipeFragment_to_profileFragment)
    }
}
