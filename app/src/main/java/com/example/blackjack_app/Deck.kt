package com.example.blackjack_app

class Deck {
    fun drawCard(): Card {
        val randomSuit = Card.Suit.values().random()
        val randomRank = Card.Rank.values().random()
        return Card(randomSuit, randomRank)
    }
}