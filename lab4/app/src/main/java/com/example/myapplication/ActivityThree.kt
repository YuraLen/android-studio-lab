package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// ВАЖЛИВО: Видаліть import android.R
// ВАЖЛИВО: Замініть import com.example.myapplication.ActivityFour на правильний шлях
import com.example.myapplication.ActivityFour

// Питання 2
class ActivityThree : AppCompatActivity(), View.OnClickListener {
    // Використовуємо lateinit для чистого коду Kotlin
    private lateinit var btnNext: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Тепер R посилається на ваші ресурси (R.layout.activity_three)
        setContentView(R.layout.activity_three)

        // Тепер R посилається на ваші ресурси (R.id.tvResult, R.id.btnNext)
        tvResult = findViewById(R.id.tvResult)
        btnNext = findViewById(R.id.btnNext)
        btnNext.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btnNext) {
            // Перехід до третього питання
            val intent = Intent(this, ActivityFour::class.java)
            startActivity(intent)
        }
    }

    fun wrongAnswer(v: View?) {
        tvResult.setText("❌ Помилка! Спробуй інший варіант.")
        tvResult.setTextColor(Color.RED)
    }

    fun correctAnswer(v: View?) {
        tvResult.setText("✅ Точно! Найдовша - річка Ніл.")
        tvResult.setTextColor(Color.parseColor("#00796B"))
    }
}