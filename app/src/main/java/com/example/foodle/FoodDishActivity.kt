package com.example.foodle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodle.adapter.NutritionCardAdapter

class FoodDishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nutrition)

        val rv = findViewById<RecyclerView>(R.id.nutrition_recycler_view)
        rv.adapter = NutritionCardAdapter(
            applicationContext,
            0
        )

        rv.layoutManager = LinearLayoutManager(this)

        // Specify fixed size to improve performance
        rv.setHasFixedSize(true)

        // Enable up button for backward navigation
        supportActionBar?.setHomeButtonEnabled(true)
    }
}