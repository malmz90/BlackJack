package com.example.blackjack_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the newGameButton
        val newGameButton = findViewById<Button>(R.id.newGameButton)

        // Set click listener
        newGameButton.setOnClickListener {
            // Create intent to open GameActivity
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }
    }
}