package com.example.visualnovelproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView

class page5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page5)

        val imageView = findViewById<ImageView>(R.id.imageView6)
        imageView.animate().apply {
            duration = 1000
            rotationYBy(15f)
        }.withEndAction {
            imageView.animate().apply {
                duration = 1000
                rotationYBy(-15f)
            }.start()
        }

        val page7_button = findViewById<Button>(R.id.button_page7)
        page7_button.setOnClickListener {
            val Intent = Intent(this,page7::class.java)
            startActivity(Intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        val page6_button = findViewById<Button>(R.id.button_page6)
        page6_button.setOnClickListener {
            val Intent = Intent(this,page6::class.java)
            startActivity(Intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }
}