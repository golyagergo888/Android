package com.tasty.recipesapp.ui.recipe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.FrameLayout
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.tasty.recipesapp.R
import com.tasty.recipesapp.data.models.ComponentModel
import com.tasty.recipesapp.data.models.IngredientModel
import com.tasty.recipesapp.data.models.InstructionModel
import com.tasty.recipesapp.data.models.InstructionTime
import com.tasty.recipesapp.data.models.RecipeModel
import com.tasty.recipesapp.data.models.SectionModel
import com.tasty.recipesapp.database.entities.RecipeEntity
import com.tasty.recipesapp.databinding.FragmentNewRecipeBinding
import com.tasty.recipesapp.providers.RepositoryProvider
import kotlinx.coroutines.launch

class NewRecipeFragment : Fragment() {

    private lateinit var binding: FragmentNewRecipeBinding;
    private var ingredients = mutableListOf<EditText>()
    private var instructions = mutableListOf<EditText>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewRecipeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addIngredientsButton.setOnClickListener{
            addNewIngredient()
        }

        binding.addInstructionButton.setOnClickListener {
            addNewInstruction()
        }

        binding.saveRecipeButton.setOnClickListener {
            saveNewRecipe()
        }
    }

    private fun addNewIngredient(){
        val newEditText = EditText(requireContext())

        newEditText.hint = "#${ingredients.size + 1} Ingredient"

        newEditText.layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )

        ingredients.add(newEditText)

        binding.ingredientsLayout.addView(newEditText)

    }

    private fun addNewInstruction(){
        val newEditText = EditText(requireContext())

        newEditText.hint = "#${instructions.size + 1} Instruction"

        newEditText.layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )

        instructions.add(newEditText)

        binding.addInstructionLayout.addView(newEditText)
    }

    private fun saveNewRecipe()
    {
        if(binding.recipeTitle.text.toString().isEmpty()){
            binding.recipeTitle.hint = "Title is Required!"
            return
        }

        if(binding.recipeCookTime.text.toString().isEmpty()){
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

        ingredients.forEach{ ing ->
            if(ing.text.toString().isNotEmpty()) {

                val ingredient = IngredientModel(timeNow.toLong(), ing.text.toString(), timeNow.toLong(), 0)

                components.add(ComponentModel(0,ing.text.toString(),ingredient,0,null))
            }
        }

        val instructionList = mutableListOf<InstructionModel>()

        var instructionCounter = 0

        instructions.forEach { ins ->
            if(ins.text.toString().isNotEmpty())
            {
                instructionCounter++

                instructionList.add(InstructionModel(instructionCounter.toLong(),ins.text.toString(), InstructionTime(0,0)))
            }
        }

        sections.add(SectionModel(0, components, null ))

        val newRecipe = RecipeModel(0,title,thumbnailUrl, description = description, sections = sections, instructions = instructionList, cookTimeMinutes = cookTime, createdAt = timeNow,
            original_video_url = null, price = null, userRatings = null, tags = null, topics = null, nutrition = null, credits = null, keywords = null)


        val recipeEntity  = RecipeEntity(0,Gson().toJson(newRecipe, RecipeModel::class.java))


        lifecycleScope.launch{
            RepositoryProvider.recipesRepository.insertRecipe(recipeEntity)
        }


        binding.recipeTitle.text.clear()
        binding.recipePictureUrl.text.clear()
        binding.recipeDescription.text.clear()

        binding.recipeCookTime.text.clear()

        ingredients.clear()
        instructions.clear()


        findNavController().navigate(R.id.action_newRecipeFragment_to_profileFragment)
    }

}