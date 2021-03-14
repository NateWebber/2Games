package com.nwebber.a2games

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class TicTacToeFragment : Fragment() {

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var clearButton: Button

    private lateinit var nextPlayer: player

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tic_tac_toe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button1 = view.findViewById(R.id.button1)
        button2 = view.findViewById(R.id.button2)
        button3 = view.findViewById(R.id.button3)
        button4 = view.findViewById(R.id.button4)
        button5 = view.findViewById(R.id.button5)
        button6 = view.findViewById(R.id.button6)
        button7 = view.findViewById(R.id.button7)
        button8 = view.findViewById(R.id.button8)
        button9 = view.findViewById(R.id.button9)
        clearButton = view.findViewById(R.id.clear_button)

        nextPlayer = player.X

        clearBoard()

        button1.setOnClickListener {
            fillTile(button1)
        }
        button2.setOnClickListener {
            fillTile(button2)
        }
        button3.setOnClickListener {
            fillTile(button3)
        }
        button4.setOnClickListener {
            fillTile(button4)
        }
        button5.setOnClickListener {
            fillTile(button5)
        }
        button6.setOnClickListener {
            fillTile(button6)
        }
        button7.setOnClickListener {
            fillTile(button7)
        }
        button8.setOnClickListener {
            fillTile(button8)
        }
        button9.setOnClickListener {
            fillTile(button9)
        }
        clearButton.setOnClickListener {
            clearBoard()
        }


    }

    private fun fillTile(tile: Button){
        var tileText = tile.text.toString()
        if(tileText == ""){ //if the tile hasn't been filled yet
            nextPlayer = when(nextPlayer){
                player.X -> {
                    tile.setText(R.string.ttt_X)
                    player.O
                }
                player.O -> {
                    tile.setText(R.string.ttt_O)
                    player.X
                }
            }
        }
    }

    private fun clearBoard(){
        button1.setText(R.string.ttt_empty)
        button2.setText(R.string.ttt_empty)
        button3.setText(R.string.ttt_empty)
        button4.setText(R.string.ttt_empty)
        button5.setText(R.string.ttt_empty)
        button6.setText(R.string.ttt_empty)
        button7.setText(R.string.ttt_empty)
        button8.setText(R.string.ttt_empty)
        button9.setText(R.string.ttt_empty)
    }

    companion object {
        fun newInstance() = TicTacToeFragment()

        enum class player{
            X, O;
        }
    }

}