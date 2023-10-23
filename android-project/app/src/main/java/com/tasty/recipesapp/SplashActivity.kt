package com.tasty.recipesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tasty.recipesapp.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("SplashActivity", "onCreate: SplashActivity created.")
        //setContentView(R.layout.activity_splash)

        // Set click listener
        val binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startButton.setOnClickListener {
            Log.d("SplashActivity", "startButton clicked.")

            // Open other activity
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("message", binding.userNameEditText.text.toString())

            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("SplashActivity", "onStart: SplashActivity started.")
    }

    override fun onResume() {
        super.onResume()
        Log.d("SplashActivity", "onResume: SplashActivity resumed.")
    }

    override fun onPause() {
        super.onPause()
        Log.d("SplashActivity", "onPause: SplashActivity paused.")
    }

    override fun onStop() {
        super.onStop()
        Log.d("SplashActivity", "onStop: SplashActivity stopped.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SplashActivity", "onDestroy: SplashActivity destroyed.")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("SplashActivity", "onRestart: SplashActivity restarted.")
    }


}