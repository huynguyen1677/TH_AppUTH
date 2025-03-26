package com.example.thuchanhapi.layouts

import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.thuchanhapi.component.HeaderHome
import com.example.thuchanhapi.component.TaskListHome
import com.example.thuchanhapi.R
import com.example.thuchanhapi.pages.Calendar
import com.example.thuchanhapi.pages.HomePage
import com.example.thuchanhapi.ui.theme.Blue_text
import com.example.thuchanhapi.viewmodel.TaskViewModel

data class NavItem(val route: String, val icon: Int, val label: String)

@Composable
fun MainScreen(modifier: Modifier = Modifier, navController: NavHostController) {
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
                    .height(100.dp)
                    .clip(RoundedCornerShape(50.dp, 50.dp, 50.dp, 50.dp)),

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
//                        label = {
//                            Text(text = item.label)
//
//                        }
                    )
                    if (index == 1) { // Sau Item 2 (index 1) thì tạo khoảng cách lớn hơn
                        Spacer(modifier = Modifier.width(60.dp)) // Tăng giảm giá trị này để chỉnh khoảng cách
                    } else if (index < navItemList.size - 1) {
                        Spacer(modifier = Modifier.width(0.dp)) // Khoảng cách bình thường giữa các item còn lại
                    }
                }
            }
//            NavigationBar(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(80.dp)
//                    .clip(RoundedCornerShape(40.dp, 40.dp, 40.dp, 40.dp)), // Bo góc tròn
//                tonalElevation = 8.dp,
//                containerColor = Color(0xFFFFFFFF),
//            ){
//                NavigationBarItem(
//                    selected = selectedIndex == 0,
//                    onClick = {
//                        selectedIndex = 0
//                        navController.navigate("home")
//                    },
//                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
//                    label = { }
//                )
//                NavigationBarItem(
//                    selected = selectedIndex == 1,
//                    onClick = {
//                        selectedIndex = 1
//                        navController.navigate("Calendar")
//                    },
//                    icon = { Icon(painterResource(id = R.drawable.calendar), contentDescription = "Calendar") },
//                    label = { }
//
//                )
//                NavigationBarItem(
//                    selected = selectedIndex == 3,
//                    onClick = {
//                        selectedIndex = 3
//                        navController.navigate("Task")
//                    },
//                    icon = { Icon(painterResource(id = R.drawable.task), contentDescription = "Task") },
//                    label = { }
//
//                )
//                NavigationBarItem(
//                    selected = selectedIndex == 4,
//                    onClick = {
//                        selectedIndex = 4
//                        navController.navigate("Setting")
//                    },
//                    icon = { Icon(painterResource(id = R.drawable.setting), contentDescription = "Settting") },
//                    label = { }
//                )
//
//            }
        },



//        bottomBar = {
//            BottomAppBar(
//                modifier = Modifier
//                    .height(80.dp)
//                    .clip(RoundedCornerShape(40.dp, 40.dp)), // Bo góc tròn
//                containerColor = Color.White,
//                tonalElevation = 8.dp
//            ) {
//
//
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(horizontal = 24.dp),
//                    horizontalArrangement = Arrangement.SpaceBetween,
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Icon(imageVector = Icons.Filled.Home, contentDescription = "Home", tint = Color.DarkGray,
//                        modifier = Modifier.size(30.dp)
//                            .clickable { navController.navigate("home") }
//                    )
//                    Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = "Calendar", tint = Color.DarkGray,
//                        modifier = Modifier.size(30.dp)
//                            .clickable { navController.navigate("home")}
//                    )
//                    Spacer(modifier = Modifier.width(56.dp)) // Tạo khoảng trống cho FAB
//                    Icon(imageVector = Icons.Filled.DateRange, contentDescription = "Documents", tint = Color.DarkGray, modifier = Modifier.size(30.dp))
//                    Icon(imageVector = Icons.Filled.Settings, contentDescription = "Settings", tint = Color.DarkGray,
//                        modifier = Modifier.size(30.dp)
//                            .clickable { navController.navigate("setting") }
//                    )
//                }
//            }
//
//
//        },
//

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
        ContentScreen(modifier = Modifier.padding(innerPadding), navController = navController, selectedIndex)

    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier,navController: NavHostController, selectedIndex: Int) {
    when(selectedIndex) {
        0 -> HomePage(viewModel = TaskViewModel(),navController)
        1 -> Calendar()
        2 -> TaskCheck()
        3 -> SettingApp()
    }
}


