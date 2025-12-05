package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private var currentNumber: String = ""
    private var currentOperator: String? = null
    private var firstOperand: Double = 0.0
    private var waitingForOperand = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tvResult)

        // Знаходимо всі кнопки та встановлюємо слухача
        setClickListeners()
    }

    private fun setClickListeners() {
        val buttonIds = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5,
            R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btnDot,
            R.id.btnAdd, R.id.btnSubtract, R.id.btnMultiply, R.id.btnDivide,
            R.id.btnEquals, R.id.btnAC
        )

        buttonIds.forEach { id ->
            findViewById<Button>(id).setOnClickListener { v ->
                onButtonClick(v)
            }
        }
    }

    private fun onButtonClick(v: View) {
        val buttonText = (v as Button).text.toString()

        when (buttonText) {
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "." -> onNumberClick(buttonText)
            "+", "-", "*", "/" -> onOperatorClick(buttonText)
            "=" -> onEqualsClick()
            "AC" -> onClearClick()
        }
    }

    private fun onNumberClick(number: String) {
        if (waitingForOperand) {
            // Починаємо нове число або очищуємо екран, якщо натиснуто оператор
            currentNumber = if (number == ".") "0." else number
            waitingForOperand = false
        } else {
            // Додаємо цифру до поточного числа
            if (number == "." && currentNumber.contains(".")) return
            currentNumber += number
        }
        tvResult.text = currentNumber
    }

    private fun onOperatorClick(operator: String) {
        if (currentNumber.isNotEmpty()) {
            firstOperand = currentNumber.toDouble()
            currentNumber = ""
        }
        currentOperator = operator
        waitingForOperand = true
    }

    private fun onEqualsClick() {
        if (currentOperator == null || currentNumber.isEmpty()) return

        val secondOperand = currentNumber.toDouble()
        val result = calculate(firstOperand, secondOperand, currentOperator!!)

        tvResult.text = formatResult(result)

        // Скидаємо стан для наступного обчислення
        firstOperand = result
        currentNumber = formatResult(result)
        currentOperator = null
        waitingForOperand = true
    }

    private fun onClearClick() {
        currentNumber = ""
        currentOperator = null
        firstOperand = 0.0
        waitingForOperand = true
        tvResult.text = "0"
    }

    // Функція форматування для уникнення ".0" у цілих числах
    private fun formatResult(value: Double): String {
        return if (value % 1 == 0.0) {
            value.toLong().toString()
        } else {
            value.toString()
        }
    }

    private fun calculate(op1: Double, op2: Double, op: String): Double {
        return when (op) {
            "+" -> op1 + op2
            "-" -> op1 - op2
            "*" -> op1 * op2
            "/" -> if (op2 != 0.0) op1 / op2 else {
                tvResult.text = "Error"
                0.0
            }
            else -> 0.0
        }
    }
}