package com.example.myapplication

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Створюємо дані
        val products: ArrayList<Product?> = ArrayList<Product?>()
        products.add(Product("Помідори", "кг."))
        products.add(Product("Миколай Roshen", "шт."))
        products.add(Product("Пиво Львівське Різдвяне 0.5л", "шт."))
        products.add(Product("Nemiroff", "л."))
        products.add(Product("Криветки", "кг."))

        // 2. Знаходимо список
        val productList = findViewById<ListView?>(R.id.productList)

        // 3. Створюємо адаптер
        val adapter: ProductAdapter = ProductAdapter(this, R.layout.list_item, products)

        // 4. Підключаємо адаптер до списку
        productList.setAdapter(adapter)
    }
}