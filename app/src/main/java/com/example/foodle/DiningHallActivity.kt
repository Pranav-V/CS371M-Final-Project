package com.example.foodle

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodle.adapter.DiningHallCardAdapter
import com.example.foodle.model.FoodData
import com.example.foodle.overview.OverviewViewModel
import kotlinx.coroutines.delay
import java.lang.Thread.sleep
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class DiningHallActivity : AppCompatActivity() {
    private val viewModel: OverviewViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dining_hall)

        viewModel.getKinsData()
        val meals = viewModel.kinsBreakfast
        Thread.sleep(10000)
        Log.d("Kins", meals.value.toString())

        val extras = intent.extras
        val diningHallName = extras?.get("diningHallName").toString()
        val rv = findViewById<RecyclerView>(R.id.foodRecyclerView)
        rv.adapter = DiningHallCardAdapter(
            applicationContext,
            0,
            diningHallName,
            "breakfast",
            meals.value!!
        )

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