package com.example.bitfit2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bitfit2.Data.Food
import com.example.bitfit2.FoodAdapter.*


class FoodAdapter(private val list:List<Food>):RecyclerView.Adapter<FoodViewHolder>() {
    class FoodViewHolder(item:View):RecyclerView.ViewHolder(item){
        val name: TextView = item.findViewById(R.id.Name)
        val calories: TextView = item.findViewById(R.id.Calories)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recylcerview_item, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = list[position]
        holder.name.text = food.name
        holder.calories.text = food.calories.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }
}