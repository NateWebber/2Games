package com.nwebber.a2games.model

import kotlin.random.Random.Default.nextInt

enum class Card{
    LEFT, RIGHT, CENTER;

    companion object{
        fun randomCard(): Card{
            return values()[nextInt(values().size)]
        }
    }
}

class CardModel {
}