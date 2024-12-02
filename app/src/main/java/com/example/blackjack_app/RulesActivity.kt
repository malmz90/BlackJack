package com.example.blackjack_app

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class RulesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rules)

        findViewById<Button>(R.id.backButton).setOnClickListener {
            finish()
        }
    }
}