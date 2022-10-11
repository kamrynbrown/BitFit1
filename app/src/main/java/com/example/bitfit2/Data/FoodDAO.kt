package com.example.bitfit2.Data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(food:Food)
    @Query("SELECT * FROM food_type ORDER BY id ASC")
    fun getAll(): Flow<List<Food>>
}

