package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// Питання 1
class ActivityTwo : AppCompatActivity(), View.OnClickListener {

    // Використовуємо lateinit для уникнення операторів безпечного виклику (!!) в onCreate
    private lateinit var btnNext: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // R.layout.activity_two
        setContentView(R.layout.activity_two)

        // R.id.tvResult та R.id.btnNext
        tvResult = findViewById(R.id.tvResult)
        btnNext = findViewById(R.id.btnNext)
        btnNext.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btnNext) {
            // Перехід до другого питання
            val intent = Intent(this, ActivityThree::class.java)
            startActivity(intent)
        }
    }

    fun wrongAnswer(v: View?) {
        tvResult.setText("❌ Неправильно. Спробуй ще!")
        tvResult.setTextColor(Color.RED)
    }

    fun correctAnswer(v: View?) {
        tvResult.setText("✅ Правильно! Молодець.")
        tvResult.setTextColor(Color.parseColor("#00796B")) // Темно-зелений для стилю
    }
}