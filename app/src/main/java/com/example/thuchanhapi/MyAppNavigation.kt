package com.example.thuchanhapi

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.thuchanhapi.layouts.GetStartedFist
import com.example.thuchanhapi.layouts.GetStartedSecond
import com.example.thuchanhapi.layouts.GetStartedThird
import com.example.thuchanhapi.layouts.MainScreen
import com.example.thuchanhapi.layouts.SplashScreen
import com.example.thuchanhapi.pages.DetailPage
import com.example.thuchanhapi.viewmodel.TaskViewModel


@Composable
fun MyAppNavigation(modifier: Modifier = Modifier , taskViewModel: TaskViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "page1") {
        composable("page1") { SplashScreen(modifier, navController) }
        composable("page2") { GetStartedFist(modifier, navController) }
        composable("page3") { GetStartedSecond(modifier, navController) }
        composable("page4") { GetStartedThird(modifier, navController) }
        composable("home") { MainScreen(modifier, navController) }
        composable(route = "detail/{taskId}",
            arguments = listOf(navArgument("taskId") { type = NavType.StringType }
            )
        ) { backStackEntry -> val taskId = backStackEntry.arguments?.getInt("taskId")
        if (taskId != null){
            DetailPage(modifier,navController, taskId)
        }
        }
    }
}
