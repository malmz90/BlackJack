package com.example.blackjack_app

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class GameActivity : AppCompatActivity() {
    private val deck = Deck()
    private val playerHand = mutableListOf<Card>()
    private val dealerHand = mutableListOf<Card>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)


            findViewById<Button>(R.id.hitButton).setOnClickListener {
                playerHit()
            }

            findViewById<Button>(R.id.standButton).setOnClickListener {
                playerStand()
            }

        startNewGame()
    }

    private fun startNewGame() {
        playerHand.clear()
        dealerHand.clear()

        dealerHand.add(deck.drawCard())
        playerHand.add(deck.drawCard())
        dealerHand.add(deck.drawCard())
        playerHand.add(deck.drawCard())

        findViewById<Button>(R.id.hitButton).isEnabled = true
        findViewById<Button>(R.id.standButton).isEnabled = true

        findViewById<CardView>(R.id.resultPanel).visibility = View.GONE

        updateUI()
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


        val resultPanel = findViewById<CardView>(R.id.resultPanel)
        resultPanel.visibility = View.VISIBLE


        findViewById<TextView>(R.id.resultText).text = result


        findViewById<Button>(R.id.playAgainButton).setOnClickListener {
            resultPanel.visibility = View.GONE
            startNewGame()
        }

        findViewById<Button>(R.id.mainMenuButton).setOnClickListener {
            finish()
        }
    }


    private fun updateUI() {
        val playerCardLayout = findViewById<LinearLayout>(R.id.playerCards)
        playerCardLayout.removeAllViews()

        val cardWidth = if (playerHand.size > 3) 200 else 300
        val cardHeight = if (playerHand.size > 3) 300 else 400

        for (card in playerHand) {
            val imageView = ImageView(this)
            imageView.setImageResource(card.getImageResource())
            imageView.layoutParams = LinearLayout.LayoutParams(cardWidth, cardHeight)
            playerCardLayout.addView(imageView)
        }

        val dealerCardLayout = findViewById<LinearLayout>(R.id.dealerCards)
        dealerCardLayout.removeAllViews()

        for (card in dealerHand) {
            val imageView = ImageView(this)
            imageView.setImageResource(card.getImageResource())
            imageView.layoutParams = LinearLayout.LayoutParams(cardWidth, cardHeight)
            dealerCardLayout.addView(imageView)
        }

        findViewById<TextView>(R.id.playerScore).text =
            "Total: ${calculateScore(playerHand)}"
        findViewById<TextView>(R.id.dealerScore).text =
            "Total: ${calculateScore(dealerHand)}"
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