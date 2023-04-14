package com.example.visualnovelproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class page6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page6)

        val imageView = findViewById<ImageView>(R.id.imageView10)
        imageView.animate().apply {
            duration = 1000
            rotationYBy(15f)
        }.withEndAction {
            imageView.animate().apply {
                duration = 1000
                rotationYBy(-15f)
            }.start()
        }

        val page12_button = findViewById<Button>(R.id.button_page12)
        page12_button.setOnClickListener {
            val Intent = Intent(this,page12::class.java)
            startActivity(Intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }
}