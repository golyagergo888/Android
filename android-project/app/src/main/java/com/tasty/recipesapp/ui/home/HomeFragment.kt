package com.tasty.recipesapp.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tasty.recipesapp.R

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("HomeFragment", "onCreate: HomeFragment created.")
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onStart() {
        super.onStart()
        Log.d("HomeFragment", "onStart: HomeFragment started.")
    }

    override fun onResume() {
        super.onResume()
        Log.d("HomeFragment", "onResume: HomeFragment resumed.")
    }

    override fun onPause() {
        super.onPause()
        Log.d("HomeFragment", "onPause: HomeFragment paused.")
    }

    override fun onStop() {
        super.onStop()
        Log.d("HomeFragment", "onStop: HomeFragment stopped.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("HomeFragment", "onDestroy: HomeFragment destroyed.")
    }
}
