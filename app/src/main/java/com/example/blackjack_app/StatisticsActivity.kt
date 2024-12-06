package com.example.blackjack_app

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StatisticsActivity : AppCompatActivity() {
    private lateinit var statsManager: StatisticsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)

        statsManager = StatisticsManager(this)

        findViewById<TextView>(R.id.gamesPlayed).text = "Games Played: ${statsManager.getGamesPlayed()}"
        findViewById<TextView>(R.id.gamesWon).text = "Games Won: ${statsManager.getGamesWon()}"
        findViewById<TextView>(R.id.gamesLost).text = "Games Lost: ${statsManager.getGamesLost()}"
        findViewById<TextView>(R.id.highestChips).text = "Highest Chips: ${statsManager.getHighestChips()}"

        findViewById<Button>(R.id.backButton).setOnClickListener {
            finish()
        }
    }
}
