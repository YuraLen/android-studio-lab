package com.example.androidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    private var scoreTeamA = 0
    private var scoreTeamB = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /** TEAM A METHODS */
    fun addThreeForTeamA(view: android.view.View) {
        scoreTeamA += 3
        displayScoreA()
    }

    fun addTwoForTeamA(view: android.view.View) {
        scoreTeamA += 2
        displayScoreA()
    }

    fun addOneForTeamA(view: android.view.View) {
        scoreTeamA++
        displayScoreA()
    }

    /** TEAM B METHODS */
    fun addThreeForTeamB(view: android.view.View) {
        scoreTeamB += 3
        displayScoreB()
    }

    fun addTwoForTeamB(view: android.view.View) {
        scoreTeamB += 2
        displayScoreB()
    }

    fun addOneForTeamB(view: android.view.View) {
        scoreTeamB++
        displayScoreB()
    }

    /** RESET BUTTON */
    fun resetScore(view: android.view.View) {
        scoreTeamA = 0
        scoreTeamB = 0
        displayScoreA()
        displayScoreB()
    }

    /** DISPLAY RESULTS */
    private fun displayScoreA() {
        val scoreViewA = findViewById<TextView>(R.id.team_a_score)
        scoreViewA.text = scoreTeamA.toString()
    }

    private fun displayScoreB() {
        val scoreViewB = findViewById<TextView>(R.id.team_b_score)
        scoreViewB.text = scoreTeamB.toString()
    }
}
