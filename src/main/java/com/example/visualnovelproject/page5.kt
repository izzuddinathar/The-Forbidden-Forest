package com.example.visualnovelproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class page5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page5)

        val page7_button = findViewById<Button>(R.id.button_page7)
        page7_button.setOnClickListener {
            val Intent = Intent(this,page7::class.java)
            startActivity(Intent)
        }

        val page6_button = findViewById<Button>(R.id.button_page6)
        page6_button.setOnClickListener {
            val Intent = Intent(this,page6::class.java)
            startActivity(Intent)
        }
    }
}