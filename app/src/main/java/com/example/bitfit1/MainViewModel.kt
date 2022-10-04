package com.example.bitfit1

import androidx.lifecycle.*
import com.example.bitfit1.Data.Food
import com.example.bitfit1.Data.FoodDAO
import kotlinx.coroutines.launch

class MainViewModel(private val DAO: FoodDAO):ViewModel() {
    val all_foods:LiveData<List<Food>> = DAO.getAll().asLiveData()
    fun insert(Fooditem:Food) = viewModelScope.launch {
        DAO.insert(Fooditem)
    }
}

class MainViewModelFactory(private val DAO: FoodDAO) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(DAO) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}