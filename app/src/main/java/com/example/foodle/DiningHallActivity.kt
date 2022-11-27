package com.example.foodle

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NavUtils
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodle.adapter.DiningHallCardAdapter
import com.example.foodle.model.FoodData
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.text.SimpleDateFormat
import java.util.*


class DiningHallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dining_hall)

        // Get a support ActionBar corresponding to this toolbar and enable the Up button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        Log.d("in dining hall activity", "making it past setContentView")
        val extras = intent.extras
        val diningHallName = extras?.get("diningHallName").toString()
        // Set name of dining hall
        findViewById<TextView>(R.id.dining_hall_name).text = diningHallName
        // Set date
        setDate()

        val radioButtonGroup: RadioGroup = findViewById(R.id.meal_selection_radio_group)
        val mealType: String = findViewById<RadioButton>(radioButtonGroup.checkedRadioButtonId)
            .text
            .toString()
            .lowercase()

        val breakfastOptionButton: RadioButton = findViewById(R.id.breakfast_button)
        val lunchOptionButton: RadioButton = findViewById(R.id.lunch_button)
        val dinnerOptionButton: RadioButton = findViewById(R.id.dinner_button)

        Log.d("dataName", mealType)
        val data = Json.decodeFromString<List<FoodData>>(extras?.get(mealType).toString())
        val rv = findViewById<RecyclerView>(R.id.foodRecyclerView)

        rv.adapter =
            DiningHallCardAdapter(
                applicationContext,
                0,
                diningHallName,
                mealType,
                data
            )

        breakfastOptionButton.setOnClickListener {
            val data = Json.decodeFromString<List<FoodData>>(extras?.get("breakfast").toString())

            rv.adapter =
                DiningHallCardAdapter(
                    applicationContext,
                    0,
                    diningHallName,
                    mealType,
                    data
                )
        }

        lunchOptionButton.setOnClickListener {
            val data = Json.decodeFromString<List<FoodData>>(extras?.get("lunch").toString())

            rv.adapter =
                DiningHallCardAdapter(
                    applicationContext,
                    0,
                    diningHallName,
                    mealType,
                    data
                )
        }

        dinnerOptionButton.setOnClickListener {
            val data = Json.decodeFromString<List<FoodData>>(extras?.get("dinner").toString())
            rv.adapter =
                DiningHallCardAdapter(
                    applicationContext,
                    0,
                    diningHallName,
                    mealType,
                    data
                )
        }

        rv.layoutManager = LinearLayoutManager(this)

        // Specify fixed size to improve performance
        rv.setHasFixedSize(true)
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

        dateTextView.text = "$day, $current"
    }
}
