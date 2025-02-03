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
            ACE -> 14
        }
    }

    fun getImageResource(): Int {
        return when {
            suit == Suit.HEARTS && rank == Rank.ACE -> R.drawable.ace_of_hearts
            suit == Suit.HEARTS && rank == Rank.TWO -> R.drawable.two_of_hearts
            suit == Suit.HEARTS && rank == Rank.THREE -> R.drawable.three_of_hearts
            suit == Suit.HEARTS && rank == Rank.FOUR -> R.drawable.four_of_hearts
            suit == Suit.HEARTS && rank == Rank.FIVE -> R.drawable.five_of_hearts
            suit == Suit.HEARTS && rank == Rank.SIX -> R.drawable.six_of_hearts
            suit == Suit.HEARTS && rank == Rank.SEVEN -> R.drawable.seven_of_hearts
            suit == Suit.HEARTS && rank == Rank.EIGHT -> R.drawable.eight_of_hearts
            suit == Suit.HEARTS && rank == Rank.NINE -> R.drawable.nine_of_hearts
            suit == Suit.HEARTS && rank == Rank.TEN -> R.drawable.ten_of_hearts
            suit == Suit.HEARTS && rank == Rank.JACK -> R.drawable.jack_of_hearts
            suit == Suit.HEARTS && rank == Rank.QUEEN -> R.drawable.queen_of_hearts
            suit == Suit.HEARTS && rank == Rank.KING -> R.drawable.king_of_hearts

            suit == Suit.DIAMONDS && rank == Rank.ACE -> R.drawable.ace_of_diamonds
            suit == Suit.DIAMONDS && rank == Rank.TWO -> R.drawable.two_of_diamonds
            suit == Suit.DIAMONDS && rank == Rank.THREE -> R.drawable.three_of_diamonds
            suit == Suit.DIAMONDS && rank == Rank.FOUR -> R.drawable.four_of_diamonds
            suit == Suit.DIAMONDS && rank == Rank.FIVE -> R.drawable.five_of_diamonds
            suit == Suit.DIAMONDS && rank == Rank.SIX -> R.drawable.six_of_diamonds
            suit == Suit.DIAMONDS && rank == Rank.SEVEN -> R.drawable.seven_of_diamonds
            suit == Suit.DIAMONDS && rank == Rank.EIGHT -> R.drawable.eight_of_diamonds
            suit == Suit.DIAMONDS && rank == Rank.NINE -> R.drawable.nine_of_diamonds
            suit == Suit.DIAMONDS && rank == Rank.TEN -> R.drawable.ten_of_diamonds
            suit == Suit.DIAMONDS && rank == Rank.JACK -> R.drawable.jack_of_diamonds
            suit == Suit.DIAMONDS && rank == Rank.QUEEN -> R.drawable.queen_of_diamonds
            suit == Suit.DIAMONDS && rank == Rank.KING -> R.drawable.king_of_diamonds

            suit == Suit.CLUBS && rank == Rank.ACE -> R.drawable.ace_of_clubs
            suit == Suit.CLUBS && rank == Rank.TWO -> R.drawable.two_of_clubs
            suit == Suit.CLUBS && rank == Rank.THREE -> R.drawable.three_of_clubs
            suit == Suit.CLUBS && rank == Rank.FOUR -> R.drawable.four_of_clubs
            suit == Suit.CLUBS && rank == Rank.FIVE -> R.drawable.five_of_clubs
            suit == Suit.CLUBS && rank == Rank.SIX -> R.drawable.six_of_clubs
            suit == Suit.CLUBS && rank == Rank.SEVEN -> R.drawable.seven_of_clubs
            suit == Suit.CLUBS && rank == Rank.EIGHT -> R.drawable.eight_of_clubs
            suit == Suit.CLUBS && rank == Rank.NINE -> R.drawable.nine_of_clubs
            suit == Suit.CLUBS && rank == Rank.TEN -> R.drawable.ten_of_clubs
            suit == Suit.CLUBS && rank == Rank.JACK -> R.drawable.jack_of_clubs
            suit == Suit.CLUBS && rank == Rank.QUEEN -> R.drawable.queen_of_clubs
            suit == Suit.CLUBS && rank == Rank.KING -> R.drawable.king_of_clubs

            suit == Suit.SPADES && rank == Rank.ACE -> R.drawable.ace_of_spades
            suit == Suit.SPADES && rank == Rank.TWO -> R.drawable.two_of_spades
            suit == Suit.SPADES && rank == Rank.THREE -> R.drawable.three_of_spades
            suit == Suit.SPADES && rank == Rank.FOUR -> R.drawable.four_of_spades
            suit == Suit.SPADES && rank == Rank.FIVE -> R.drawable.five_of_spades
            suit == Suit.SPADES && rank == Rank.SIX -> R.drawable.six_of_spades
            suit == Suit.SPADES && rank == Rank.SEVEN -> R.drawable.seven_of_spades
            suit == Suit.SPADES && rank == Rank.EIGHT -> R.drawable.eight_of_spades
            suit == Suit.SPADES && rank == Rank.NINE -> R.drawable.nine_of_spades
            suit == Suit.SPADES && rank == Rank.TEN -> R.drawable.ten_of_spades
            suit == Suit.SPADES && rank == Rank.JACK -> R.drawable.jack_of_spades
            suit == Suit.SPADES && rank == Rank.QUEEN -> R.drawable.queen_of_spades
            suit == Suit.SPADES && rank == Rank.KING -> R.drawable.king_of_spades

            else -> R.drawable.back
        }
    }
}