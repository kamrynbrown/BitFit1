package com.example.bitfit2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bitfit2.Data.Food
import com.example.bitfit2.Data.FoodDatabase
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    lateinit var BottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BottomNav = findViewById(R.id.BottomNav)
        supportFragmentManager.beginTransaction().replace(R.id.Frame, DashboardFragment()).commit()
        BottomNav.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener {
            lateinit var selectedfragement:Fragment
            when(it.itemId){
                R.id.Dashboard->{
                    selectedfragement = DashboardFragment()
                }
                R.id.AddNewFood->{
                    selectedfragement = AddFoodFragment()
                }
            }
            supportFragmentManager.beginTransaction().replace(R.id.Frame, selectedfragement).commit()
            true
        })
    }
}