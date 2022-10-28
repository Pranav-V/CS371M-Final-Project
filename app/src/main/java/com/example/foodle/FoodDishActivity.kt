package com.example.foodle

import android.app.ActionBar
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class FoodDishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_dish)

        supportActionBar?.setHomeButtonEnabled(true)
    }
}