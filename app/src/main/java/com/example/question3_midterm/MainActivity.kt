package com.example.question3_midterm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCalculator: Button = findViewById(R.id.button_calculator)
        val buttonCountryInfo: Button = findViewById(R.id.button_country_info)

        buttonCalculator.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }

        buttonCountryInfo.setOnClickListener {
            val intent = Intent(this, CountryInfoActivity::class.java)
            startActivity(intent)
        }
    }
}
