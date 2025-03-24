package com.example.thuchanhapi.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.thuchanhapi.component.EmptyTaskHome
import com.example.thuchanhapi.component.HeaderHome
import com.example.thuchanhapi.component.TaskListHome
import com.example.thuchanhapi.viewmodel.TaskViewModel

@Composable
fun HomePage(viewModel: TaskViewModel = viewModel()) {
    val tasks = viewModel.tasks.observeAsState(emptyList()).value // Lấy danh sách công việc
    val isLoading = viewModel.isLoading.observeAsState(true).value
    Column(
        Modifier.fillMaxSize()
    ) {
        HeaderHome()


        when {
        isLoading -> { CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally)) }
            tasks.isEmpty() -> {
                EmptyTaskHome()
            }
            else -> {
                TaskListHome()
            }
    }

}
}