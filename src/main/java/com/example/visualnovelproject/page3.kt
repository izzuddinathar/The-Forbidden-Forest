package com.example.visualnovelproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class page3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page3)

        val textView2 = findViewById<TextView>(R.id.textView2)

        val userName = intent.getStringExtra("name")
        textView2.text= "Your name is " +userName +", hiking in a mexico forest, you realize that it is going dark and you see an abandoned cabin, what would you do?"
        val page4_button = findViewById<Button>(R.id.button_page4)
        page4_button.setOnClickListener {
            val Intent = Intent(this,page4::class.java)
            startActivity(Intent)
        }
        val page12_button = findViewById<Button>(R.id.button_page12)
        page12_button.setOnClickListener {
            val Intent = Intent(this,page12::class.java)
            startActivity(Intent)
        }
    }
}