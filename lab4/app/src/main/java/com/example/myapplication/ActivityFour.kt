package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// Питання 3
class ActivityFour : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnNext: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // R тепер посилається на ваші ресурси (activity_four)
        setContentView(R.layout.activity_four)

        // R тепер посилається на ваші ресурси (tvResult, btnNext)
        tvResult = findViewById(R.id.tvResult)
        btnNext = findViewById(R.id.btnNext)
        btnNext.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btnNext) {
            // Перехід до екрану завершення
            val intent = Intent(this, ActivityFive::class.java)
            startActivity(intent)
        }
    }

    fun wrongAnswer(v: View?) {
        tvResult.setText("❌ Ні, це не Азія.")
        tvResult.setTextColor(Color.RED)
    }

    fun correctAnswer(v: View?) {
        tvResult.setText("✅ Правильно! Це Південна Америка.")
        tvResult.setTextColor(Color.parseColor("#00796B"))
    }
}