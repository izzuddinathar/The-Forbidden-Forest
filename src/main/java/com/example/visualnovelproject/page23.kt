package com.example.visualnovelproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class page23 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page23)

        val page24_button = findViewById<Button>(R.id.button_page24)
        page24_button.setOnClickListener {
            val Intent = Intent(this,page24::class.java)
            startActivity(Intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
        val page25_button = findViewById<Button>(R.id.button_page25)
        page25_button.setOnClickListener {
            val Intent = Intent(this,page25::class.java)
            startActivity(Intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }
}