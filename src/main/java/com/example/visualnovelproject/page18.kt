package com.example.visualnovelproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class page18 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page18)

        val page19_button = findViewById<Button>(R.id.button_page19)
        page19_button.setOnClickListener {
            val Intent = Intent(this,page19::class.java)
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