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
        gamesCounter = 0
        gamesCounterNumber.setText(gamesCounter)
    }
}