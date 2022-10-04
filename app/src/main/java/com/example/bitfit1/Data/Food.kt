package com.example.bitfit1.Data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food_type")
data class Food(@PrimaryKey(autoGenerate = true)
                val id: Int?=null,
                val name: String,
                val calories: Int) {
}