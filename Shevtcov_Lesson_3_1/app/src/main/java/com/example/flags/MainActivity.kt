package com.example.flags

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageButton = findViewById<ImageView>(R.id.on_Linear_activity)
        imageButton.setOnClickListener() {
            val switchIntent = Intent(this, LinearLayoutActivity::class.java)
            startActivity(switchIntent)
        }
    }
}