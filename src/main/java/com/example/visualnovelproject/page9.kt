package com.example.visualnovelproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class page9 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page9)

        val page10_button = findViewById<Button>(R.id.button_page10)
        page10_button.setOnClickListener {
            val Intent = Intent(this,page10::class.java)
            startActivity(Intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        val page11_button = findViewById<Button>(R.id.button_page11)
        page11_button.setOnClickListener {
            val Intent = Intent(this,page11::class.java)
            startActivity(Intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }
}