package com.example.visualnovelproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class page7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page7)

        val imageView = findViewById<ImageView>(R.id.imageView8)
        imageView.animate().apply {
            duration = 1000
            rotationYBy(15f)
        }.withEndAction {
            imageView.animate().apply {
                duration = 1000
                rotationYBy(-15f)
            }.start()
        }

        val page8_button = findViewById<Button>(R.id.button_page8)
        page8_button.setOnClickListener {
            val Intent = Intent(this,page8::class.java)
            startActivity(Intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        val page9_button = findViewById<Button>(R.id.button_page9)
        page9_button.setOnClickListener {
            val Intent = Intent(this,page9::class.java)
            startActivity(Intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }
}