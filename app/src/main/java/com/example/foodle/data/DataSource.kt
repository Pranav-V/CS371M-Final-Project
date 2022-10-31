/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.foodle.data

import com.example.foodle.R
import com.example.foodle.model.Food

/**
 * An object to generate a static list of foods
 */
object DataSource {
    val cinnamonNutritionList: List<String> = listOf(
        "Serving Size: 1 roll",
        "Calories: 270",
        "Total Fat: 8.2g",
        "Saturated Fat: 3.3g",
        "Trans Fat: 0g",
        "Cholesterol 14.5mg",
        "Sodium: 274.3mg",
        "Total Carbs: 42g",
        "Dietary Fiber: 0g",
        "Total Sugars 12.4g",
        "Added Sugars: 0g",
        "Protein: 6g"
    )

    val foods: List<Food> = listOf(
        Food(
            "Mini Cinnamon Roll",
            "Milk, Eggs, Wheat, Soybeans",
            cinnamonNutritionList,
            ""
        ),
        Food(
            "Housemade Hummus",
            "None",
            listOf(),
            "cheese"
        ),
        Food(
            "Candied Sweet Potatoes",
            "Soybeans",
            listOf(),
            "cheese"
        ),
        Food(
            "Mexican Lasagna",
            "Milk, Eggs",
            listOf(),
            "cheese"
        )
    )
}
