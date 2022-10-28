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
 * An object to generate a static list of dogs
 */
object DataSource {

    val foods: List<Food> = listOf(
        Food(
            "Mini Cinnamon Roll",
            "7",
            "sunbathing",
            "cheese"
        ),
        Food(
            "Sweet Potato Muffin",
            "4",
            "sleeping in dangerous places",
            "cheese"
        ),
        Food(
            "Beef Congee",
            "2",
            "stealing socks",
            "cheese"
        ),
        Food(
            "Banana",
            "8",
            "meeting new animals",
            "cheese"
        )
    )
}
