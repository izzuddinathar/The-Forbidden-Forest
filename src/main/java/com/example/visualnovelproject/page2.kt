package com.example.visualnovelproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class page2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)

        val input_button = findViewById<Button>(R.id.button_input)
        val input_name = findViewById<EditText>(R.id.inputName)
        input_button.setOnClickListener {
            val Intent = Intent(this,page3::class.java)
                .putExtra("name",input_name.text.toString())
            startActivity(Intent)
        }
    }
}