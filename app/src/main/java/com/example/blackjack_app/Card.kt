package com.example.blackjack_app

data class Card(val suit: Suit, val rank: Rank) {

    enum class Suit { HEARTS, DIAMONDS, CLUBS, SPADES }
    enum class Rank {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN,
        JACK, QUEEN, KING, ACE;

        fun getValue(): Int = when(this) {
            TWO -> 2
            THREE -> 3
            FOUR -> 4
            FIVE -> 5
            SIX -> 6
            SEVEN -> 7
            EIGHT -> 8
            NINE -> 9
            TEN -> 10
            JACK, QUEEN, KING -> 10
            ACE -> 11
        }
    }

        override fun toString(): String {
            return "$rank of $suit"
        }

}