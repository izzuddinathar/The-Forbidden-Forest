package com.example.visualnovelproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class page14 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page14)

        val restart_button = findViewById<Button>(R.id.button_restart)
        restart_button.setOnClickListener {
            val Intent = Intent(this,page1::class.java)
            startActivity(Intent)
        }
    }
}