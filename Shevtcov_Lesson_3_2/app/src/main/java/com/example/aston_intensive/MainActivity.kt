package com.example.aston_intensive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.constraintlayout.widget.Group

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val contacts = findViewById<Button>(R.id.contacts)
        val vacations = findViewById<Button>(R.id.vacations)
        val gallery = findViewById<Button>(R.id.gallery)
        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        val chipsAndButtons = findViewById<Group>(R.id.group)
        contacts.setOnClickListener{
            chipsAndButtons.visibility = View.INVISIBLE
            progressBar.visibility = View.VISIBLE
        }
        vacations.setOnClickListener{
            chipsAndButtons.visibility = View.INVISIBLE
            progressBar.visibility = View.VISIBLE
        }
        gallery.setOnClickListener{
            chipsAndButtons.visibility = View.INVISIBLE
            progressBar.visibility = View.VISIBLE
        }
    }
}