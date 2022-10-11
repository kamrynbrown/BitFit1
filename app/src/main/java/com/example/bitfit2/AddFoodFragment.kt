package com.example.bitfit2


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import com.example.bitfit2.Data.Food
import com.example.bitfit2.Data.FoodDAO
import com.example.bitfit2.Data.FoodDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class AddFoodFragment : Fragment(){
    lateinit var foodName: EditText
    lateinit var foodCalories: EditText
    lateinit var newFoodButton: Button
    private lateinit var dao: FoodDAO;
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.add_food_fragment, container, false)
        foodName = view.findViewById(R.id.FoodName)
        foodCalories = view.findViewById(R.id.FoodCalories)
        newFoodButton = view.findViewById(R.id.foodadd)
        dao = FoodDatabase.getDatabase(requireContext()).foodDAO();
        newFoodButton.setOnClickListener {
            lifecycleScope.launch() {
                dao.insert(Food(name = foodName.text.toString(), calories = foodCalories.text.toString().toInt()))
            }
        };
        return view;
    }
}