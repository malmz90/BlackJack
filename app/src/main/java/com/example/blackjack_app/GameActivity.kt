package com.example.blackjack_app

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {
    private val deck = Deck()
    private val playerHand = mutableListOf<Card>()
    private val dealerHand = mutableListOf<Card>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        startNewGame()
    }

    private fun startNewGame() {
        playerHand.clear()
        dealerHand.clear()

        dealerHand.add(deck.drawCard())
        playerHand.add(deck.drawCard())
        dealerHand.add(deck.drawCard())
        playerHand.add(deck.drawCard())

        updateUI()
    }

    private fun updateUI() {
        findViewById<TextView>(R.id.dealerScore).text =
            "Dealer: ${calculateScore(dealerHand)}"

        findViewById<TextView>(R.id.playerScore).text =
            "Player: ${calculateScore(playerHand)}"
    }

    private fun calculateScore(hand: List<Card>): Int {
        var score = 0
        var aces = 0

        // First sum up all non-aces
        for (card in hand) {
            if (card.rank == Card.Rank.ACE) {
                aces++
            } else {
                score += card.rank.getValue()
            }
        }

        // Add aces
        for (i in 1..aces) {
            score += if (score + 11 <= 21) 11 else 1
        }

        return score
    }
}