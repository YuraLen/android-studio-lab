package com.example.myapplication

import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var friendsList: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        friendsList = findViewById<ListView?>(R.id.friendsList)

        // 1. Формуємо список колонок, які хочемо отримати
        val projection = arrayOf<String?>(
            FriendsContract.Columns._ID,  // ID обов'язково потрібен для адаптера
            FriendsContract.Columns.NAME,  // Ім'я
            FriendsContract.Columns.PHONE // Телефон
        )

        // 2. Отримуємо ContentResolver
        val resolver = getContentResolver()

        // 3. Робимо запит до нашого Провайдера (query)
        // Це аналог SQL: SELECT * FROM friends
        val cursor = resolver.query(
            FriendsContract.CONTENT_URI,  // URI (адреса таблиці)
            projection,  // Які колонки брати
            null,  // WHERE (умова) - тут беремо всіх
            null,  // Аргументи умови
            null // Сортування
        )

        // 4. Налаштовуємо адаптер для списку
        if (cursor != null) {
            // Звідки беремо дані (назви колонок у БД)
            val fromColumns = arrayOf<String?>(
                FriendsContract.Columns.NAME,
                FriendsContract.Columns.PHONE
            )

            // Куди кладемо дані (ID текстових полів у стандартному макеті Android)
            // android.R.layout.simple_list_item_2 - це стандартний макет з двома рядками тексту
            val toViews = intArrayOf(
                android.R.id.text1,  // Верхній великий текст (для Імені)
                android.R.id.text2 // Нижній менший текст (для Телефону)
            )

            // Створюємо адаптер
            val adapter = SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_2,  // Стандартний дизайн рядка
                cursor,
                fromColumns,
                toViews,
                0
            )

            // 5. Прив'язуємо адаптер до ListView
            friendsList!!.setAdapter(adapter)
        }
    }
}