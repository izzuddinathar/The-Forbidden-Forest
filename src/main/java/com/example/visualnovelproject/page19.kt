package com.example.visualnovelproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class page19 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page19)

        val page20_button = findViewById<Button>(R.id.button_page20)
        page20_button.setOnClickListener {
            val Intent = Intent(this,page20::class.java)
            startActivity(Intent)
        }
        val page23_button = findViewById<Button>(R.id.button_page23)
        page23_button.setOnClickListener {
            val Intent = Intent(this,page23::class.java)
            startActivity(Intent)
        }
    }
}