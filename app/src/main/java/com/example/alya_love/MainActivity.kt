package com.example.alya_love

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup Toolbar
        setSupportActionBar(findViewById(R.id.toolbar))

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Load Home Fragment pertama kali + set judul
        if (savedInstanceState == null) {
            loadFragment(HomeFragment())
            updateToolbarTitle("Home")
        }

        // Handle navigasi Bottom Navigation
        bottomNavigation.setOnItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.nav_home -> {
                    updateToolbarTitle("Home")
                    HomeFragment()
                }
                R.id.nav_about -> {
                    updateToolbarTitle("About")
                    AboutFragment()
                }
                R.id.nav_profile -> {
                    updateToolbarTitle("Profile")
                    ProfileFragment()
                }
                else -> {
                    updateToolbarTitle("Home")
                    HomeFragment()
                }
            }
            loadFragment(fragment)
            true
        }
    }

    // 🔹 Fungsi ganti fragment
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    // 🔹 Fungsi ganti judul toolbar ⭐ BARU
    private fun updateToolbarTitle(title: String) {
        supportActionBar?.title = title
    }
}