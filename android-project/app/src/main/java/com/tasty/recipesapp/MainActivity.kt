package com.tasty.recipesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tasty.recipesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", "onCreate: MainActivity created.")

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getStringExtra("message")
        binding.getTextView.text = result
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