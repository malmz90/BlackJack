package com.example.blackjack_app

import android.content.Context
import android.content.SharedPreferences

class StatisticsManager(context: Context) {
    private val preferences: SharedPreferences =
        context.getSharedPreferences("game_stats", Context.MODE_PRIVATE)

    fun incrementGamesPlayed() {
        preferences.edit().putInt("games_played", getGamesPlayed() + 1).apply()
    }

    fun incrementGamesWon() {
        preferences.edit().putInt("games_won", getGamesWon() + 1).apply()
    }

    fun incrementGamesLost() {
        preferences.edit().putInt("games_lost", getGamesLost() + 1).apply()
    }

    fun updateHighestChips(chips: Int) {
        if (chips > getHighestChips()) {
            preferences.edit().putInt("highest_chips", chips).apply()
        }
    }

    fun getGamesPlayed(): Int = preferences.getInt("games_played", 0)
    fun getGamesWon(): Int = preferences.getInt("games_won", 0)
    fun getGamesLost(): Int = preferences.getInt("games_lost", 0)
    fun getHighestChips(): Int = preferences.getInt("highest_chips", 500)
}
