package com.example.visualnovelproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class page13 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page13)

        val page14_button = findViewById<Button>(R.id.button_page14)
        page14_button.setOnClickListener {
            val Intent = Intent(this,page14::class.java)
            startActivity(Intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
        val page15_button = findViewById<Button>(R.id.button_page15)
        page15_button.setOnClickListener {
            val Intent = Intent(this,page15::class.java)
            startActivity(Intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }
}