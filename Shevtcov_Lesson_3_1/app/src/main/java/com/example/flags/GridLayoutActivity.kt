package com.example.flags

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class GridLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_layout)
        val imageButton = findViewById<ImageView>(R.id.on_main_activity)
        imageButton.setOnClickListener() {
            val switchIntent = Intent(this, MainActivity::class.java)
            startActivity(switchIntent)
        }
    }
}