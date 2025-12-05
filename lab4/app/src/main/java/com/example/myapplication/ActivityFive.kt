package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ActivityFive : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnHome: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // R тепер посилається на ваші ресурси (activity_five)
        setContentView(R.layout.activity_five)

        // R тепер посилається на ваші ресурси (btnHome)
        btnHome = findViewById(R.id.btnHome)
        btnHome.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        // Повернення на головний екран
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}