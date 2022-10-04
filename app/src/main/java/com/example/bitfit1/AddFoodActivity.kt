package com.example.bitfit1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddFoodActivity:AppCompatActivity(){
    lateinit var FoodName:EditText
    lateinit var FoodCalories:EditText
    lateinit var NewFoodButton:Button
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food)
        FoodName = findViewById(R.id.FoodName)
        FoodCalories = findViewById(R.id.FoodCalories)
        NewFoodButton = findViewById(R.id.foodadd)
        NewFoodButton.setOnClickListener(View.OnClickListener {
            var intent = Intent()
            intent.putExtra("name", FoodName.text.toString())
            intent.putExtra("calories", FoodCalories.text.toString().toInt())
            setResult(Activity.RESULT_OK, intent)
            finish()
        })
    }
}