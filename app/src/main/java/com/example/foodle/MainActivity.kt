package com.example.foodle

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.drawerlayout.widget.DrawerLayout
import com.example.foodle.overview.OverviewViewModel
import com.google.android.material.navigation.NavigationView
import okhttp3.*
import java.io.File
import java.io.IOException
import java.net.URL
import java.util.ArrayList


class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
//    private val viewModel: OverviewViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
            val intent = Intent(this, DiningHallActivity::class.java)
            intent.putExtra("diningHallName", "Jester City Limits")
            startActivity(intent)
        }

        val j2Button = findViewById<Button>(R.id.j2button)
        j2Button.setOnClickListener {
            val intent = Intent(this, DiningHallActivity::class.java)
            intent.putExtra("diningHallName", "J2")
            startActivity(intent)
        }

        val fastJ2Button = findViewById<Button>(R.id.fastj2button)
        fastJ2Button.setOnClickListener {
            val intent = Intent(this, DiningHallActivity::class.java)
            intent.putExtra("diningHallName", "Fast @ J2")
            startActivity(intent)
        }

        val kinsButton = findViewById<Button>(R.id.kinsbutton)
        kinsButton.setOnClickListener {
            val intent = Intent(this, DiningHallActivity::class.java)
            intent.putExtra("diningHallName", "Kins")
            startActivity(intent)
        }

        val jestaPizzaButton = findViewById<Button>(R.id.jestapizzabutton)
        jestaPizzaButton.setOnClickListener {
            val intent = Intent(this, DiningHallActivity::class.java)
            intent.putExtra("diningHallName", "Jesta' Pizza")
            startActivity(intent)
        }

        val littlefieldButton = findViewById<Button>(R.id.littlefieldbutton)
        littlefieldButton.setOnClickListener {
            val intent = Intent(this, DiningHallActivity::class.java)
            intent.putExtra("diningHallName", "Littlefield Cafe")
            startActivity(intent)
        }

        val cypressbendButton = findViewById<Button>(R.id.cypressbendbutton)
        cypressbendButton.setOnClickListener {
            val intent = Intent(this, DiningHallActivity::class.java)
            intent.putExtra("diningHallName", "Cypress Bend Cafe")
            startActivity(intent)
        }

        val jcmButton = findViewById<Button>(R.id.jcmbutton)
        jcmButton.setOnClickListener {
            val intent = Intent(this, DiningHallActivity::class.java)
            intent.putExtra("diningHallName", "Jester City Market")
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