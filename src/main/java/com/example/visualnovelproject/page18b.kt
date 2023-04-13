package com.example.visualnovelproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class page18b : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page18b)

        val page21_button = findViewById<Button>(R.id.button_page21)
        page21_button.setOnClickListener {
            val Intent = Intent(this,page21::class.java)
            startActivity(Intent)
        }
        val page23_button = findViewById<Button>(R.id.button_page23)
        page23_button.setOnClickListener {
            val Intent = Intent(this,page23::class.java)
            startActivity(Intent)
        }
    }
}