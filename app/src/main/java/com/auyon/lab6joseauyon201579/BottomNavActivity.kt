package com.auyon.lab6joseauyon201579

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.commit

class BottomNavActivity : AppCompatActivity() {
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)

        bottomNav = findViewById(R.id.bottomNav_bottomNavActivity)
        setCurrentFragment(HomeFragment())
        setListeners()
    }

    private fun setListeners() {
        bottomNav.setOnItemSelectedListener {
            // Dependiendo el item del menu, mostramos el fragment deseado
            when(it.itemId) {
                R.id.item_home -> setCurrentFragment(HomeFragment())
                R.id.item_search -> setCurrentFragment(SearchFragment())
                R.id.item_library -> setCurrentFragment(LibraryFragment())
            }
            true
        }
    }

    /**
     * Función que reemplaza el fragment actual. No usamos backstack porque
     * para este tipo de navegación, no es el comportamiento esperado.
     */
    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragmentContainer_bottomNavActivity, fragment)
        }
    }
}