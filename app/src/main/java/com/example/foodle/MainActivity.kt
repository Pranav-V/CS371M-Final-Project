package com.example.foodle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jclButton = findViewById<Button>(R.id.jclbutton)
        jclButton.setOnClickListener {
            val intent = Intent(this, DiningHallActivity::class.java)
            startActivity(intent)
        }
    }
}