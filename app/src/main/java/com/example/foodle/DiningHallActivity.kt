package com.example.foodle

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodle.adapter.DiningHallCardAdapter
import java.text.SimpleDateFormat
import java.util.*


class DiningHallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dining_hall)

        val extras = intent.extras
        val rv = findViewById<RecyclerView>(R.id.foodRecyclerView)
        rv.adapter = DiningHallCardAdapter(
            applicationContext,
            0
        )

        val diningHallName = extras?.get("diningHallName").toString()
//        val diningHallTitle = findViewById<TextView>(R.id.dining_hall_title)
//        diningHallTitle.text = diningHallName

        setDate()

        rv.layoutManager = LinearLayoutManager(this)

        // Specify fixed size to improve performance
        rv.setHasFixedSize(true)

        // Enable up button for backward navigation
        supportActionBar?.setHomeButtonEnabled(true)
    }

    private fun setDate() {
        val calendar = Calendar.getInstance()
        val formatter = SimpleDateFormat("dd MMMM yyyy")
        val current = formatter.format(calendar.time)
        val dateTextView = findViewById<TextView>(R.id.date)

        val day = when(calendar.get(Calendar.DAY_OF_WEEK)) {
            1 -> "Sunday"
            2 -> "Monday"
            3 -> "Tuesday"
            4 -> "Wednesday"
            5 -> "Thursday"
            6 -> "Friday"
            7 -> "Saturday"
            else -> "TIME ERROR"
        }

        dateTextView.text = day + ", " + current
    }
}