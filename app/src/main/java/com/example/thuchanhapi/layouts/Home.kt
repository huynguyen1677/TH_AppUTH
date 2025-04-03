package com.example.thuchanhapi.layouts

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.thuchanhapi.R
import com.example.thuchanhapi.login.GoogleAuthUiClient
import com.example.thuchanhapi.pages.Calendar
import com.example.thuchanhapi.pages.HomePage
import com.example.thuchanhapi.ui.theme.Blue_text
import com.example.thuchanhapi.viewmodel.TaskViewModel
import kotlinx.coroutines.launch

data class NavItem(val route: String, val icon: Int, val label: String)

@Composable
fun MainScreen(modifier: Modifier = Modifier, navController: NavHostController, googleAuthUiClient: GoogleAuthUiClient) {
    val navItemList = listOf(
        NavItem("home", R.drawable.home, "Home"),
        NavItem("Calendar", R.drawable.calendar, "Calendar"),
        NavItem("Task", R.drawable.task, "Task"),
        NavItem("Setting", R.drawable.setting, "Setting")
    )

    var selectedIndex by remember { mutableStateOf(0) }
    Scaffold(
        Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),

                tonalElevation = 20.dp,
                containerColor = Color(0xFFFFFFFF),
            ){

                navItemList.forEachIndexed { index, item ->
                    NavigationBarItem(
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Blue_text,
                            selectedTextColor = Blue_text,
                            indicatorColor = Color.White,
                            unselectedIconColor = Color.Gray,
                            unselectedTextColor = Color.Gray
                        ),

                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index

                        },
                        icon = { Icon(painterResource(id = item.icon),
                            modifier = Modifier.size(35.dp),
                            contentDescription = item.label) },

//                        }
                    )

                }
            }
        },



        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* TODO */ },
                containerColor = Color(0xFF2196F3),
                shape = CircleShape,
                modifier = Modifier
                    .offset(y = 45.dp)
                    .size(65.dp)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add", tint = Color.White)
            }
        },
        floatingActionButtonPosition = FabPosition.Center // FAB nằm giữa
    ) { innerPadding ->
        ContentScreen(modifier = Modifier.padding(innerPadding), navController = navController, selectedIndex, googleAuthUiClient)

    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier,navController: NavHostController, selectedIndex: Int, googleAuthUiClient: GoogleAuthUiClient) {
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    when(selectedIndex) {
        0 -> HomePage(viewModel = TaskViewModel(),navController)
        1 -> Calendar()
        2 -> TaskCheck()
        3 -> ProfileScreen(userData = googleAuthUiClient.getSignedInUser(),
            onSignOut = {
                coroutineScope.launch {
                    googleAuthUiClient.signOut()
                    Toast.makeText(context, "Signed out", Toast.LENGTH_LONG).show()
                    navController.popBackStack()
                }
            },
            navController
        )
    }
}

