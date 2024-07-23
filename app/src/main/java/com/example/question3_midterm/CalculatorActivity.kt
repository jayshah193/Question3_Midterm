package com.example.question3_midterm

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {

    private lateinit var editTextNum1: EditText
    private lateinit var editTextNum2: EditText
    private lateinit var spinnerOperations: Spinner
    private lateinit var buttonCalculate: Button
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        editTextNum1 = findViewById(R.id.edittext_num1)
        editTextNum2 = findViewById(R.id.edittext_num2)
        spinnerOperations = findViewById(R.id.spinner_operations)
        buttonCalculate = findViewById(R.id.button_calculate)
        textViewResult = findViewById(R.id.textview_result)

        val operations = listOf("+", "-", "*", "/")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, operations)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerOperations.adapter = adapter

        buttonCalculate.setOnClickListener {
            val num1 = editTextNum1.text.toString().toDoubleOrNull()
            val num2 = editTextNum2.text.toString().toDoubleOrNull()
            val operation = spinnerOperations.selectedItem.toString()

            if (num1 != null && num2 != null) {
                val result = when (operation) {
                    "+" -> num1 + num2
                    "-" -> num1 - num2
                    "*" -> num1 * num2
                    "/" -> num1 / num2
                    else -> Double.NaN
                }

                textViewResult.text = result.toString()

                // Send result to ResultActivity
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("result_data", "Calculator Result: $result")
                startActivity(intent)
            }
        }
    }
}
