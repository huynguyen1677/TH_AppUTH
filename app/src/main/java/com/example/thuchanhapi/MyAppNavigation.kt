package com.example.thuchanhapi

import android.app.Activity.RESULT_OK
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.thuchanhapi.layouts.GetStartedFist
import com.example.thuchanhapi.layouts.GetStartedSecond
import com.example.thuchanhapi.layouts.GetStartedThird
import com.example.thuchanhapi.layouts.MainScreen
import com.example.thuchanhapi.layouts.ProfileScreen
import com.example.thuchanhapi.layouts.SplashScreen
import com.example.thuchanhapi.login.GoogleAuthUiClient
import com.example.thuchanhapi.login.SignInScreen
import com.example.thuchanhapi.login.SignInViewModel
import com.example.thuchanhapi.pages.DetailPage
import com.example.thuchanhapi.viewmodel.TaskViewModel
import kotlinx.coroutines.launch


@Composable
fun MyAppNavigation(
    modifier: Modifier = Modifier,
    taskViewModel: TaskViewModel,
    googleAuthUiClient: GoogleAuthUiClient
) {
    val tasks = taskViewModel.tasks.observeAsState(initial = emptyList()).value
    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current


    NavHost(navController = navController, startDestination = "page1") {
        composable("page1") { SplashScreen(modifier, navController) }
        composable("page2") { GetStartedFist(modifier, navController) }
        composable("page3") { GetStartedSecond(modifier, navController) }
        composable("page4") { GetStartedThird(modifier, navController) }


        composable("home") {MainScreen(modifier, navController, googleAuthUiClient)}
        composable("login") {
            val viewModel = viewModel<SignInViewModel>()
            val state by viewModel.state.collectAsStateWithLifecycle()

            LaunchedEffect(key1 = Unit) {
                if(googleAuthUiClient.getSignedInUser() != null) {
                    navController.navigate("home")
                }
            }

            val launcher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.StartIntentSenderForResult(),
                onResult = { result ->
                    if (result.resultCode == RESULT_OK) {
                        coroutineScope.launch {
                            val signInResult = googleAuthUiClient.signInWithIntent(
                                intent = result.data ?: return@launch
                            )
                            viewModel.onSignInResult(signInResult)
                        }
                    }
                }
            )

            LaunchedEffect(state.isSignInSuccessful) {
                if (state.isSignInSuccessful) {
                    Toast.makeText(context, "Sign in successful", Toast.LENGTH_LONG).show()
                    navController.navigate("home")
                    viewModel.resetState()
                }
            }

            SignInScreen(
                state = state,
                onSignInClick = {
                    coroutineScope.launch {
                        val signInIntentSender = googleAuthUiClient.signIn()
                        launcher.launch(
                            IntentSenderRequest.Builder(
                                signInIntentSender ?: return@launch
                            ).build()
                        )
                    }
                },
                navController
            )
        }
//        composable("signup") { SignUpScreen(modifier, navController) }

        composable("profile") {
            ProfileScreen(
                userData = googleAuthUiClient.getSignedInUser(),
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





        composable(
            route = "detail/{taskId}",
            arguments = listOf(navArgument("taskId") { type = NavType.IntType })
        ) { backStackEntry ->
            val taskId = backStackEntry.arguments?.getInt("taskId")
            val task = tasks.find { it.id == taskId }

            if (taskId != null && task != null) {
                DetailPage(modifier, taskViewModel, navController, taskId)
            } else {
                navController.popBackStack() // Quay lại nếu task không tồn tại
            }
        }
    }
}