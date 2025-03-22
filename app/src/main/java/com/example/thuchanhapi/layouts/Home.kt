package com.example.thuchanhapi.layouts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.thuchanhapi.component.HeaderHome
import com.example.thuchanhapi.component.TaskListHome

@Composable
fun HomePage(modifier: Modifier = Modifier, navController: NavHostController) {

    Scaffold(
        Modifier.fillMaxSize(),
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .height(80.dp)
                    .clip(RoundedCornerShape(40.dp, 40.dp)), // Bo góc tròn
                containerColor = Color.White,
                tonalElevation = 8.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Filled.Home, contentDescription = "Home", tint = Color.DarkGray,
                        modifier = Modifier.size(30.dp)
                            .clickable { navController.navigate("home") }
                    )
                    Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = "Calendar", tint = Color.DarkGray,
                        modifier = Modifier.size(30.dp)
                            .clickable { navController.navigate("home")}
                    )
                    Spacer(modifier = Modifier.width(56.dp)) // Tạo khoảng trống cho FAB
                    Icon(imageVector = Icons.Filled.DateRange, contentDescription = "Documents", tint = Color.DarkGray, modifier = Modifier.size(30.dp))
                    Icon(imageVector = Icons.Filled.Settings, contentDescription = "Settings", tint = Color.DarkGray,
                        modifier = Modifier.size(30.dp)
                            .clickable { navController.navigate("setting") }
                    )
                }
            }


        },

        
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* TODO */ },
                containerColor = Color(0xFF2196F3),
                shape = CircleShape,
                modifier = Modifier.offset(y = 45.dp)
                    .size(65.dp)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add", tint = Color.White)
            }
        },
        floatingActionButtonPosition = FabPosition.Center // FAB nằm giữa
    ) { innerPadding ->

        Column(
            Modifier
                .fillMaxSize()
        ) {
            HeaderHome(modifier = modifier.padding(innerPadding))

            TaskListHome()
        }
    }
}




@Composable
fun NavigationHome(){

}