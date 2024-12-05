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
    private var chips = 500
    private val betAmount = 50

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
        if (chips < betAmount) {
            endGame("You are out of chips!")
            return
        }

        playerHand.clear()
        dealerHand.clear()

        dealerHand.add(deck.drawCard())
        playerHand.add(deck.drawCard())
        dealerHand.add(deck.drawCard())
        playerHand.add(deck.drawCard())

        findViewById<Button>(R.id.hitButton).isEnabled = true
        findViewById<Button>(R.id.standButton).isEnabled = true

        findViewById<CardView>(R.id.resultPanel).visibility = View.GONE
        updateChipStack()
        updateUI()
    }

    private fun playerHit() {
        playerHand.add(deck.drawCard())

        if (calculateScore(playerHand) > 21) {
            chips -= betAmount
            endGame("Bust! Dealer wins!\nYou lose $betAmount chips.")
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
            dealerScore > 21 -> {
                chips += betAmount
                "Dealer busts! You win!\nYou win $betAmount chips."
            }
            playerScore > dealerScore -> {
                chips += betAmount
                "You win!\nYou win $betAmount chips."
            }
            playerScore < dealerScore -> {
                chips -= betAmount
                "Dealer wins!\nYou lose $betAmount chips."
            }
            else -> "Push (Tie)!\nNo chips won or lost."
        }

        endGame(result)
    }

    private fun updateChipStack() {
        findViewById<TextView>(R.id.chipStack).text = "Chips: $chips"
    }


    private fun endGame(result: String) {
        findViewById<Button>(R.id.hitButton).isEnabled = false
        findViewById<Button>(R.id.standButton).isEnabled = false

        val resultPanel = findViewById<CardView>(R.id.resultPanel)
        resultPanel.visibility = View.VISIBLE

        findViewById<TextView>(R.id.resultText).text = result

        updateChipStack()

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

        for (card in hand) {
            if (card.rank == Card.Rank.ACE) {
                aces++
            } else {
                score += card.rank.getValue()
            }
        }

        for (i in 1..aces) {
            score += if (score + 11 <= 21) 11 else 1
        }

        return score
    }
}
