package com.example.visualnovelproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class page16 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page16)

        val page18a_button = findViewById<Button>(R.id.button_page18a)
        page18a_button.setOnClickListener {
            val Intent = Intent(this,page18::class.java)
            startActivity(Intent)
        }
        val page18b_button = findViewById<Button>(R.id.button_page18b)
        page18b_button.setOnClickListener {
            val Intent = Intent(this,page18b::class.java)
            startActivity(Intent)
        }
    }
}