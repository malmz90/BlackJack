package com.example.blackjack_app

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newGameButton = findViewById<Button>(R.id.newGameButton)
        val rulesButton = findViewById<Button>(R.id.rulesButton)

        newGameButton.setOnClickListener {
            Toast.makeText(this, "Starting new game...", Toast.LENGTH_SHORT).show()
        }

        rulesButton.setOnClickListener {
            Toast.makeText(this, "Opening rules...", Toast.LENGTH_SHORT).show()
        }
    }
}