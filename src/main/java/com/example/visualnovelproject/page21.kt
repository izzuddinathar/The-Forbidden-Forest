package com.example.visualnovelproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class page21 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page21)

        val page22_button = findViewById<Button>(R.id.button_page22)
        page22_button.setOnClickListener {
            val Intent = Intent(this,page22::class.java)
            startActivity(Intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
        val page23_button = findViewById<Button>(R.id.button_page23)
        page23_button.setOnClickListener {
            val Intent = Intent(this,page23::class.java)
            startActivity(Intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }
}