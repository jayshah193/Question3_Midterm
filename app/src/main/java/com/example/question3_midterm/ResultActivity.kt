package com.example.question3_midterm

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    private lateinit var textViewResultData: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        textViewResultData = findViewById(R.id.textview_result_data)

        val resultData = intent.getStringExtra("result_data")
        textViewResultData.text = resultData
    }
}
