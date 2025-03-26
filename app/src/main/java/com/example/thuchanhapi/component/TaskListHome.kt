package com.example.thuchanhapi.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.thuchanhapi.model.Task
import com.example.thuchanhapi.ui.theme.high_color
import com.example.thuchanhapi.ui.theme.low_color
import com.example.thuchanhapi.ui.theme.medium_color
import com.example.thuchanhapi.viewmodel.TaskViewModel


@Composable
fun TaskListHome(modifier: Modifier = Modifier ,taskViewModel: TaskViewModel = viewModel(), navController: NavController ) {
    val tasks = taskViewModel.tasks.observeAsState(initial = emptyList())
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column() {
            Spacer(modifier = Modifier.padding(8.dp))
            LazyColumn {
                items(tasks.value) { task ->
                    TaskItem(task = task, navController = navController)
                }
            }
        }
    }
}

@Composable
fun TaskItem(task: Task, navController: NavController) {
    var isChecked = remember { mutableStateOf(false) }
    val ColorCardList = listOf(
        Color(0xFFFFF1F1), // Hồng nhạt
        Color(0xFFFFF8E1), // Vàng kem
        Color(0xFFE1F5FE), // Xanh dương pastel
        Color(0xFFE8F5E9), // Xanh lá nhạt
        Color(0xFFFFF3E0), // Cam pastel
        Color(0xFFEDE7F6), // Tím nhạt
        Color(0xFFFCE4EC), // Hồng phấn
        Color(0xFFFFF9C4)  // Vàng nhạt
    )
    val randomColor = remember {ColorCardList.random()}

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 8.dp)
            .clickable{
                navController.navigate("detail/${task.id}")
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = when (task.priority){
                        "High" -> high_color
                        "Medium" -> medium_color
                        "Low" -> low_color
                        else -> randomColor
                    }
                )
                .padding(16.dp)
        ) {

            Row {
                Checkbox(checked = isChecked.value, onCheckedChange = { isChecked.value = it })
                Column {
                    // Task Name (Title)
                    Text(
                        text = task.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.padding(4.dp))

                    // Task Description
                    Text(
                        text = task.description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Black
                    )
                }
            }

            Spacer(modifier = Modifier.padding(4.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "Status: ${task.status}",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.weight(1f)

                )
                Text(
                    text = task.dueDate,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.DarkGray,
                )

            }
        }
    }
}