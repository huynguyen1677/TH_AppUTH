package com.example.thuchanhapi

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.thuchanhapi.layouts.GetStartedFist
import com.example.thuchanhapi.layouts.GetStartedSecond
import com.example.thuchanhapi.layouts.GetStartedThird
import com.example.thuchanhapi.layouts.HomePage
import com.example.thuchanhapi.layouts.SettingApp
import com.example.thuchanhapi.layouts.SplashScreen


@Composable
fun MyAppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "page1") {
        composable("page1") { SplashScreen(modifier, navController) }
        composable("page2") { GetStartedFist(modifier, navController) }
        composable("page3") { GetStartedSecond(modifier, navController) }
        composable("page4") { GetStartedThird(modifier, navController) }
        composable("home") { HomePage(modifier, navController) }
        composable("setting") { SettingApp(modifier, navController) }
    }
}
