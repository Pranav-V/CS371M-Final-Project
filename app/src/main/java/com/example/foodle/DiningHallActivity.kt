package com.example.foodle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodle.adapter.DiningHallCardAdapter


class DiningHallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dining_hall)

        val rv = findViewById<RecyclerView>(R.id.foodRecyclerView)
        rv.adapter = DiningHallCardAdapter(
            applicationContext,
            0
        )

        rv.layoutManager = LinearLayoutManager(this)

        // Specify fixed size to improve performance
        rv.setHasFixedSize(true)

        // Enable up button for backward navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}