package com.example.islamiapp

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.islamiapp.hadeth.hadeth
import com.example.islamiapp.quran.quran
import com.example.islamiapp.radio.radio
import com.example.islamiapp.sebha.sebha
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var navBar: BottomNavigationView

    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var toolbar: Toolbar
    lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inintView()
        handleNightMode()
        handleBootomNavigationView()
    }

//    private fun changeLanguage(language: String) {
//        var local:Locale= Locale(language)
//        Locale.setDefault(local)
//        var configuration=Configuration()
//        configuration.setLocale(local)
//        baseContext.resources.updateConfiguration(configuration,baseContext.resources.displayMetrics)
////        var res:Resources=resources
////        var dm:DisplayMetrics=res.displayMetrics
////        var conf:Configuration=res.configuration
////        conf.setLocale(Locale(language.lowercase()))
////        res.updateConfiguration(conf,dm)
//    }

    private fun handleBootomNavigationView() {
        navBar = findViewById(R.id.Nav_Bar)
        navBar.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener {
            if (it.itemId == R.id.quran) {
                pushFragment(quran())
            } else if (it.itemId == R.id.hadeth) {
                pushFragment(hadeth())
            } else if (it.itemId == R.id.sebha) {
                pushFragment(sebha())
            } else if (it.itemId == R.id.radio) {
                pushFragment(radio())
            }

            return@OnItemSelectedListener true
        })
        navBar.selectedItemId = R.id.quran

    }

    private fun handleNightMode() {
        navigationView = findViewById(R.id.nav)
        navigationView.setNavigationItemSelectedListener {
            if (it.itemId == R.id.night) {
                if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    navBar.selectedItemId = R.id.quran
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    navBar.selectedItemId = R.id.quran

                }
            }

            return@setNavigationItemSelectedListener true
        }

    }

    //init view we use to show side menu and show humborger icon
    private fun inintView() {
        drawerLayout = findViewById(R.id.drawer)
        toolbar = findViewById(R.id.toolbar)
        //here we use toolbar instead of tool bar
        setSupportActionBar(toolbar)
        //here we use to appear a burger icon
        actionBarDrawerToggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.open_drawer,
            R.string.close_drawer
        )
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        //handle animation here
        actionBarDrawerToggle.syncState()


    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_continer, fragment)
            .commit()
    }


}