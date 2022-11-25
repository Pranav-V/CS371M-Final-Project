package com.example.foodle

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.drawerlayout.widget.DrawerLayout
import com.example.foodle.model.FoodData
import com.example.foodle.overview.OverviewViewModel
import com.google.android.material.navigation.NavigationView
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.JsonNull.serializer


class MainActivity : AppCompatActivity() {
    private val viewModel: OverviewViewModel by viewModels()

    private val emptyListJsonString: String = """[{"name":"Couldn't query database","category":"Please check again later","link":"https://www.youtube.com/watch?v=dQw4w9WgXcQ"}]"""
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getData()

        // Ref: https://www.youtube.com/watch?v=do4vb0MdLFY
        val drawerLayout = findViewById<DrawerLayout>(R.id.mainContainer)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navView = findViewById<NavigationView>(R.id.nav_view)
        navView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.app_bar_switch -> {
                    Toast.makeText(applicationContext, "Dark Mode Toggled", Toast.LENGTH_SHORT)
                        .show()
                    toggleDarkMode()
                }
                else -> Toast.makeText(applicationContext, "Error in NavDrawer", Toast.LENGTH_SHORT).show()
            }
            true
        }

        val jclButton = findViewById<Button>(R.id.jclbutton)
        jclButton.setOnClickListener {
            var intent = Intent(this, DiningHallActivity::class.java)
            val data = viewModel.jclData
            val jsonList = when (Json.encodeToString(data)) {
                "null" -> emptyListJsonString
                "[]" -> emptyListJsonString
                else -> Json.encodeToString(data)
            }
            intent.putExtra("diningHallName", "Jester City Limits")
            intent.putExtra("data", jsonList)
            startActivity(intent)
        }

        val j2Button = findViewById<Button>(R.id.j2button)
        j2Button.setOnClickListener {
            val intent = Intent(this, DiningHallActivity::class.java)
            intent.putExtra("diningHallName", "J2")
            val data = viewModel.j2Dinner.value
            val jsonList = when (Json.encodeToString(data)) {
                "null" -> emptyListJsonString
                "[]" -> emptyListJsonString
                else -> Json.encodeToString(data)
            }
            intent.putExtra("data", jsonList)
            startActivity(intent)
        }

        val fastJ2Button = findViewById<Button>(R.id.fastj2button)
        fastJ2Button.setOnClickListener {
            val intent = Intent(this, DiningHallActivity::class.java)
            val data = viewModel.j2Dinner.value
            val jsonList = when (Json.encodeToString(data)) {
                "null" -> emptyListJsonString
                "[]" -> emptyListJsonString
                else -> Json.encodeToString(data)
            }
            intent.putExtra("diningHallName", "Fast @ J2")
            intent.putExtra("data", jsonList)
            startActivity(intent)
        }

        val kinsButton = findViewById<Button>(R.id.kinsbutton)
        kinsButton.setOnClickListener {
            val intent = Intent(this, DiningHallActivity::class.java)
            val data: List<List<FoodData>> =
                listOf(viewModel.kinsBreakfast.value, viewModel.kinsLunch.value, viewModel.kinsDinner.value) as List<List<FoodData>>
            val jsonList = when (Json.encodeToString(data)) {
                "null" -> emptyListJsonString
                "[]" -> emptyListJsonString
                else -> Json.encodeToString(data)
            }
            intent.putExtra("diningHallName", "Kins")
            intent.putExtra("data", jsonList)
            Log.d("dataList", jsonList)
            startActivity(intent)
        }

        val jestaPizzaButton = findViewById<Button>(R.id.jestapizzabutton)
        jestaPizzaButton.setOnClickListener {
            val intent = Intent(this, DiningHallActivity::class.java)
            val data = viewModel.jestaDinner.value
            val jsonList = when (Json.encodeToString(data)) {
                "null" -> emptyListJsonString
                "[]" -> emptyListJsonString
                else -> Json.encodeToString(data)
            }
            intent.putExtra("diningHallName", "Jesta' Pizza")
            intent.putExtra("data", jsonList)
            startActivity(intent)
        }

        val littlefieldButton = findViewById<Button>(R.id.littlefieldbutton)
        littlefieldButton.setOnClickListener {
            val intent = Intent(this, DiningHallActivity::class.java)
            val data = viewModel.littlefieldDinner.value
            val jsonList = when (Json.encodeToString(data)) {
                "null" -> emptyListJsonString
                "[]" -> emptyListJsonString
                else -> Json.encodeToString(data)
            }
            intent.putExtra("diningHallName", "Littlefield Cafe")
            intent.putExtra("data", jsonList)
            startActivity(intent)
        }

        val cypressbendButton = findViewById<Button>(R.id.cypressbendbutton)
        cypressbendButton.setOnClickListener {
            val intent = Intent(this, DiningHallActivity::class.java)
            val data = viewModel.kinsDinner.value
            val jsonList = when (Json.encodeToString(data)) {
                "null" -> emptyListJsonString
                "[]" -> emptyListJsonString
                else -> Json.encodeToString(data)
            }
            intent.putExtra("diningHallName", "Cypress Bend Cafe")
            intent.putExtra("data", jsonList)
            startActivity(intent)
        }

        val jcmButton = findViewById<Button>(R.id.jcmbutton)
        jcmButton.setOnClickListener {
            val intent = Intent(this, DiningHallActivity::class.java)
            val data = viewModel.j2Dinner.value
            val jsonList = when (Json.encodeToString(data)) {
                "null" -> emptyListJsonString
                "[]" -> emptyListJsonString
                else -> Json.encodeToString(data)
            }
            intent.putExtra("diningHallName", "Jester City Market")
            intent.putExtra("data", jsonList)
            startActivity(intent)
        }
    }

    private fun toggleDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}