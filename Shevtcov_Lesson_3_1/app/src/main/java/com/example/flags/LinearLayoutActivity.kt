package com.example.flags

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class LinearLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_layout)
        val imageButton = findViewById<ImageView>(R.id.on_grid_activity)
        imageButton.setOnClickListener() {
            val switchIntent = Intent(this, GridLayoutActivity::class.java)
            startActivity(switchIntent)
        }

    }
}