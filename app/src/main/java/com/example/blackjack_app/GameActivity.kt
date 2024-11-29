package com.example.blackjack_app

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {
    private val deck = Deck()
    private val playerHand = mutableListOf<Card>()
    private val dealerHand = mutableListOf<Card>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        setupButtons()
        startNewGame()
    }

    private fun setupButtons() {
        findViewById<Button>(R.id.hitButton).setOnClickListener {
            playerHit()
        }

        findViewById<Button>(R.id.standButton).setOnClickListener {
            playerStand()
        }
    }

    private fun playerHit() {
        playerHand.add(deck.drawCard())

        if (calculateScore(playerHand) > 21) {
            endGame("Bust! Dealer wins!")
        }

        updateUI()
    }

    private fun playerStand() {
        while (calculateScore(dealerHand) < 17) {
            dealerHand.add(deck.drawCard())
        }
        updateUI()
        val playerScore = calculateScore(playerHand)
        val dealerScore = calculateScore(dealerHand)

        val result = when {
            dealerScore > 21 -> "Dealer busts! You win!"
            playerScore > dealerScore -> "You win!"
            playerScore < dealerScore -> "Dealer wins!"
            else -> "Push (Tie)!"
        }

        endGame(result)
    }

    private fun endGame(result: String) {
        findViewById<Button>(R.id.hitButton).isEnabled = false
        findViewById<Button>(R.id.standButton).isEnabled = false

        Toast.makeText(this, result, Toast.LENGTH_LONG).show()

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
        findViewById<TextView>(R.id.dealerCards).text =
            "Cards: ${dealerHand.joinToString(", ")}\n" +
                    "Total: ${calculateScore(dealerHand)}"

        findViewById<TextView>(R.id.playerCards).text =
            "Cards: ${playerHand.joinToString(", ")}\n" +
                    "Total: ${calculateScore(playerHand)}"
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