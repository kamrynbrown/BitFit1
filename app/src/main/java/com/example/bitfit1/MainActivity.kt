package com.example.bitfit1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bitfit1.Data.Food
import com.example.bitfit1.Data.FoodDatabase
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class MainActivity : AppCompatActivity() {
    lateinit var r: RecyclerView
    lateinit var AddNewFoodButton:Button
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        r = findViewById(R.id.NutritionTracker)
        AddNewFoodButton = findViewById(R.id.AddNewFood)
        var foodDatabase = FoodDatabase.getDatabase(this)
        viewModel = MainViewModelFactory(foodDatabase.foodDAO()).create(MainViewModel::class.java)
        viewModel.all_foods.observe(this, Observer { food->
            r.adapter = FoodAdapter(food)
        })
        r.layoutManager = LinearLayoutManager(this)
        AddNewFoodButton.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AddFoodActivity::class.java)
            startActivityForResult(intent, 1)
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK){
            viewModel.insert(Food(name = data!!.getStringExtra("name")!!, calories = data!!.getIntExtra("calories", 0)))
        }
    }
}