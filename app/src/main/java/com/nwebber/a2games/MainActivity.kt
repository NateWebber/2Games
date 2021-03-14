package com.nwebber.a2games

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var gamesCounter = 0
    private lateinit var gamesCounterNumber: TextView
    private lateinit var startCardsButton: Button
    private lateinit var startTTTButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startCardsButton = findViewById(R.id.start_card_button)
        startTTTButton = findViewById(R.id.start_ttt_button)
        gamesCounter = 0
        gamesCounterNumber = findViewById(R.id.times_played_counter)
        gamesCounterNumber.setText(gamesCounter.toString())

        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, CardsFragment.newInstance()).commitNow()
            startCardsButton.isEnabled = false
            startTTTButton.isEnabled = true
        }

        startCardsButton.setOnClickListener {
            incrementCounter()
            startCardsButton.isEnabled = false
            startTTTButton.isEnabled = true
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, CardsFragment.newInstance()).commitNow()
        }
        startTTTButton.setOnClickListener {
            incrementCounter()
            startCardsButton.isEnabled = true
            startTTTButton.isEnabled = false
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, TicTacToeFragment.newInstance()).commitNow()
        }
    }

    //quickly add one to game counter and update the text view
    private fun incrementCounter(){
        gamesCounter++
        gamesCounterNumber.setText(gamesCounter.toString())
    }
    enum class current_game{
        CARDS, TTT;
    }
}