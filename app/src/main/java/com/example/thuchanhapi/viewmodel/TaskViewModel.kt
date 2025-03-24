package com.example.thuchanhapi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thuchanhapi.api.RetrofitInstance
import com.example.thuchanhapi.model.Task
import com.example.thuchanhapi.model.TaskResponse
import kotlinx.coroutines.launch

class TaskViewModel : ViewModel() {
    private val _tasks = MutableLiveData<List<Task>>()
    val tasks: LiveData<List<Task>> = _tasks

    private val _isLoading = MutableLiveData(true) // Bắt đầu với trạng thái đang tải
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        getTasks()
    }

    private fun getTasks() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getTasks()
                if (response.isSuccessful) {
                    val taskResponse: TaskResponse? = response.body()
                    _tasks.value = taskResponse?.data
                } else {
                    // Handle the error (e.g., log the error)
                    println("Error: ${response.code()}")
                }
            } catch (e: Exception) {
                // Handle exceptions (e.g., log the exception)
                println("Exception: ${e.message}")
            } finally {
                _isLoading.value = false // Khi tải xong, đặt isLoading thành false
            }
        }
    }
}