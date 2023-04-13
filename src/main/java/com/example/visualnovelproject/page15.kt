package com.example.visualnovelproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class page15 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page15)

        val page16_button = findViewById<Button>(R.id.button_page16)
        page16_button.setOnClickListener {
            val Intent = Intent(this,page16::class.java)
            startActivity(Intent)
        }
        val page17_button = findViewById<Button>(R.id.button_page17)
        page17_button.setOnClickListener {
            val Intent = Intent(this,page17::class.java)
            startActivity(Intent)
        }
    }
}