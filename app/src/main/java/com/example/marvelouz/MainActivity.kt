package com.example.marvelouz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.marvelouz.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(),View.OnClickListener {

    lateinit var board: Array<Array<Button>>
    private lateinit var binding: ActivityMainBinding
    var PLAYER = true
    var TURN_COUNT = 0

    var boardStatus = Array(3) {IntArray(3)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        board = arrayOf(
            arrayOf(binding.bt1, binding.bt2, binding.bt3),
            arrayOf(binding.bt4, binding.bt5, binding.bt6),
            arrayOf(binding.bt7, binding.bt8, binding.bt9)
        )

        initialiseBoardStatus();

        for(i in board){
            for(button in i){
                button.setOnClickListener(this)
            }
        }
        binding.resetBtn.setOnClickListener{
            PLAYER = true
            TURN_COUNT = 0
            initialiseBoardStatus()
            updateText("Player X Turn")
        }
    }

    private fun initialiseBoardStatus() {
        for(i in 0..2){
            for(j in 0..2){
                boardStatus[i][j] = -1
            }
        }

        for(i in board){
            for(button in i){
                button.isEnabled = true
                button.text = ""
            }
        }
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.bt1->{
                updateValue(row=0,col=0,player = PLAYER)
            }
            R.id.bt2->{
                updateValue(row=0,col=1,player = PLAYER)
            }
            R.id.bt3->{
                updateValue(row=0,col=2,player = PLAYER)
            }
            R.id.bt4->{
                updateValue(row=1,col=0,player = PLAYER)
            }
            R.id.bt5->{
                updateValue(row=1,col=1,player = PLAYER)
            }
            R.id.bt6->{
                updateValue(row=1,col=2,player = PLAYER)
            }
            R.id.bt7->{
                updateValue(row=2,col=0,player = PLAYER)
            }
            R.id.bt8->{
                updateValue(row=2,col=1,player = PLAYER)
            }
            R.id.bt9->{
                updateValue(row=2,col=2,player = PLAYER)
            }
        }
        TURN_COUNT++
        PLAYER = !PLAYER

        if(PLAYER) updateText("Player X Turn")
        else updateText("Player Y Turn")

        if(TURN_COUNT==9){
            updateText("Game Draw")
        }

        checkWinner()
    }

    private fun checkWinner() {
        // Horizontal Rows
        for(i in 0..2){
           if(boardStatus[i][0]==boardStatus[i][1] && boardStatus[i][0]==boardStatus[i][2]){
               if(boardStatus[i][0]==1){
                   updateText("Player X is the winner")
                   break
               }else if(boardStatus[i][0]==0){
                   updateText("Player 0 is the winner")
                   break
               }
           }
        }

        // Vertical Rows
        for(i in 0..2){
            if(boardStatus[0][i]==boardStatus[1][i] && boardStatus[0][i]==boardStatus[2][i]){
                if(boardStatus[0][i]==1){
                    updateText("Player X is the winner")
                    break
                }else if(boardStatus[0][i]==0){
                    updateText("Player 0 is the winner")
                    break
                }
            }
        }

        // First Diagonal Rows
        if(boardStatus[0][0]==boardStatus[1][1] && boardStatus[0][0]==boardStatus[2][2]){
            if(boardStatus[0][0]==1){
                updateText("Player X is the winner")
            }else if(boardStatus[0][0]==0){
                updateText("Player 0 is the winner")
            }
        }

        // Second Diagonal Rows
        if(boardStatus[0][2]==boardStatus[1][1] && boardStatus[0][2]==boardStatus[2][0]){
            if(boardStatus[0][2]==1){
                updateText("Player X is the winner")
            }else if(boardStatus[0][2]==0){
                updateText("Player 0 is the winner")
            }
        }
    }

    private fun updateText(text: String) {
        binding.tvPlayer.text = text
    }

    private fun updateValue(row: Int, col: Int, player: Boolean) {
        val text: String = if(player) "X" else "0"
        val value: Int = if(player) 1 else 0
        board[row][col].apply {
            isEnabled = false
            setText(text)
        }
        boardStatus[row][col] = value
    }
}