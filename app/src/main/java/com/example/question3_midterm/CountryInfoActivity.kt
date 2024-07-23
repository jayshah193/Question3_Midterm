package com.example.question3_midterm

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CountryInfoActivity : AppCompatActivity() {

    private lateinit var spinnerCountries: Spinner
    private lateinit var buttonShowInfo: Button
    private lateinit var textViewCountryInfo: TextView

    private val countryInfoMap = mapOf(
        "USA" to "Capital: Washington D.C.\nPopulation: 331 million",
        "Canada" to "Capital: Ottawa\nPopulation: 38 million",
        "UK" to "Capital: London\nPopulation: 68 million",
        "Australia" to "Capital: Canberra\nPopulation: 26 million",
        "India" to "Capital: New Delhi\nPopulation: 1.4 billion"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_info)

        spinnerCountries = findViewById(R.id.spinner_countries)
        buttonShowInfo = findViewById(R.id.button_show_info)
        textViewCountryInfo = findViewById(R.id.textview_country_info)

        val countries = countryInfoMap.keys.toList()
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCountries.adapter = adapter

        spinnerCountries.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                // No action needed here
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // No action needed here
            }
        }

        buttonShowInfo.setOnClickListener {
            val selectedCountry = spinnerCountries.selectedItem.toString()
            val info = countryInfoMap[selectedCountry]
            textViewCountryInfo.text = info

            // Send country info to ResultActivity
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("result_data", "Country Info: $info")
            startActivity(intent)
        }
    }
}
