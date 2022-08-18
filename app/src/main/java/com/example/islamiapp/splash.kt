package com.example.islamiapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        splash()

    }

    private fun moveToHome() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun splash() {

        Handler(Looper.getMainLooper()).postDelayed({ moveToHome() }, 2000)
    }

}