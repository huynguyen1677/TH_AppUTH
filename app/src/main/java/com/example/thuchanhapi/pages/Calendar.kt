package com.example.thuchanhapi.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.thuchanhapi.component.HeaderHome
import com.example.thuchanhapi.component.TaskListHome

@Composable
fun Calendar() {
    Column(
        Modifier
            .fillMaxSize()
    ) {
        HeaderHome()

    }
}