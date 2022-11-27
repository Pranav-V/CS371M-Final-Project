package com.example.foodle

import android.app.Application
import com.google.android.material.color.DynamicColors

class FoodleApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        DynamicColors.applyToActivitiesIfAvailable(this)
    }
}