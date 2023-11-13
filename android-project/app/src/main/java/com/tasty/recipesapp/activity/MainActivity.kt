package com.tasty.recipesapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tasty.recipesapp.R
import com.tasty.recipesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        Log.d("MainActivity", "onCreate: MainActivity created.")
//
//        val binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("MainActivity", "onCreate: MainActivity created.")

        val navController  = this.findNavController( R.id.nav_host_fragment)
        val bottomNavigationView: BottomNavigationView = binding.bottomNavigation
        bottomNavigationView.setupWithNavController(navController)
        bottomNavigationView.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.homeFragment -> {
                    navController.navigate(R.id.homeFragment)
                    true
                }
                R.id.profileFragment -> {
                    navController.navigate(R.id.profileFragment)
                    true
                }
                R.id.recipesFragment -> {
                    navController.navigate(R.id.recipesFragment)
                    true
                }
                else -> false
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart: MainActivity started.")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume: MainActivity resumed.")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause: MainActivity paused.")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop: MainActivity stopped.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy: MainActivity destroyed.")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onRestart: MainActivity restarted.")
    }
}