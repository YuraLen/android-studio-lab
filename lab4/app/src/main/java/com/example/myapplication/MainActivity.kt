package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

// Головний екран
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnStart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Тепер R.layout.activity_main посилається на R з com.example.lab4
        setContentView(R.layout.activity_main)

        // Тепер R.id.btnStart посилається на R з com.example.lab4
        btnStart = findViewById(R.id.btnStart)
        btnStart.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        // R.id.btnStart - звернення до ID з вашого XML
        if (v.id == R.id.btnStart) {
            // Перехід до першого питання
            val intent = Intent(this, ActivityTwo::class.java)
            startActivity(intent)
        }
    }
}