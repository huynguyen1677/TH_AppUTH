package com.example.thuchanhapi.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.thuchanhapi.R
import com.example.thuchanhapi.ui.theme.Blue_text

@Composable
fun SignInScreen(
    state: SignInState,
    onSignInClick: () -> Unit,
//    authViewModel: AuthViewModel,
    navController: NavController
) {
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }

    val context = LocalContext.current


//    val authState = authViewModel.authState.observeAsState()

//    LaunchedEffect(authState.value) {
//        when(authState.value){
//            is AuthState.Authenticated -> navController.navigate("home")
//            is AuthState.Error -> Toast.makeText(context,
//                (authState.value as AuthState.Error).message, Toast.LENGTH_SHORT).show()
//            else -> Unit
//        }
//    }

    LaunchedEffect(key1 = state.signInError) {
        state.signInError?.let { error ->
            Toast.makeText(
                context,
                error,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box (
                modifier = Modifier
                    .size(230.dp)
                    .background(Color(0xFFD5EDFF), RoundedCornerShape(8.dp)),
            ){

                Image(
                    painter = painterResource(id = R.drawable.uth_logo),
                    contentDescription = "Logo",
                    modifier = Modifier.fillMaxWidth()
                        .size(100.dp)
                        .align(Alignment.Center)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "SmartTasks",
                color = Blue_text,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,

            )
            Text(
                "A simple and efficient to-do app",
                color = Blue_text,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 14.sp,
                )
            Spacer(modifier = Modifier.height(130.dp))
            Text(
                "Welcome",
                color = Color.Black,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 18.sp,
                )

            Text(
                "Ready to explore? Log in to get started.",
                color = Color.Black,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp,
            )


//            OutlinedTextField(
//                value = email,
//                onValueChange = {
//                    email = it
//                },
//                label = {
//                    Text(text = "Email")
//                }
//            )
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            OutlinedTextField(
//                value = password,
//                onValueChange = {
//                    password = it
//                },
//                label = {
//                    Text(text = "Password")
//                }
//            )
//            TextButton(onClick = {
//                navController.navigate("fogotpassword")
//            }) {
//                Text(text = "Forgot password?")
//            }

            Spacer(modifier = Modifier.height(16.dp))

//            Button(
//                onClick = {
//                    authViewModel.login1(email,password)
//                },
//                enabled = authState.value != AuthState.Loading,
//                colors = ButtonDefaults.buttonColors(
//                    containerColor = Blue_text,
//                    contentColor = Color.White
//                ),
//                modifier = Modifier.width(150.dp)
//                    .height(50.dp)
//                    .align(Alignment.CenterHorizontally)
//            ) {
//                Text(text = "Login")
//            }
//            TextButton(onClick = {
//                navController.navigate("signup")
//            }) {
//                Text(text = "Don't have an account, Signup")
//            }

            Button(
                onClick = onSignInClick,
                modifier = Modifier.align(Alignment.CenterHorizontally)
                    .width(300.dp)
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFD5EDFF),
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(8.dp)

            ) {
                Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = "Google Icon"
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Sign in with Google")
            }
        }

    }
}