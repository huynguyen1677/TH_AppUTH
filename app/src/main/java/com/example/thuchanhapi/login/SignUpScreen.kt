//package com.example.thuchanhapi.login
//
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.outlined.Lock
//import androidx.compose.material.icons.outlined.MailOutline
//import androidx.compose.material3.Button
//import androidx.compose.material3.Icon
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextButton
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.livedata.observeAsState
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import com.example.thuchanhapi.ui.theme.Blue_text
//
//
//@Composable
//fun SignUpScreen(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {
//    var email by remember {
//        mutableStateOf("")
//    }
//
//    var password by remember {
//        mutableStateOf("")
//    }
//    val authState = authViewModel.authState.observeAsState()
//    val context = LocalContext.current
//    Column (
//        modifier = Modifier.fillMaxSize()
//            .padding(20.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ){
//        Text(
//            text = "Create Account",
//            modifier = Modifier.align(Alignment.CenterHorizontally),
//            fontSize = 30.sp,
//            fontWeight = FontWeight.Bold,
//            )
//        Spacer(modifier = Modifier.height(16.dp))
//        Text(
//            "Sign up",
//            modifier = Modifier.align(Alignment.Start),
//            fontSize = 28.sp,
//            fontWeight = FontWeight.Bold,
//            color = Blue_text
//        )
//        // email
//        Column(modifier = Modifier.padding(16.dp)) {
//            Row(verticalAlignment = Alignment.CenterVertically) {
//                Icon(
//                    imageVector = Icons.Outlined.MailOutline,
//                    contentDescription = "User Icon",
//                    tint = Color.Gray,
//                    modifier = Modifier.size(16.dp)
//                )
//                Spacer(modifier = Modifier.width(8.dp))
//                Text(
//                    text = "Your Email",
//                    color = Color.Gray,
//                    fontSize = 14.sp
//                )
//            }
//
//            Spacer(modifier = Modifier.height(4.dp))
//
//            OutlinedTextField(
//                modifier = Modifier.fillMaxWidth(),
//                value = email,
//                onValueChange = {
//                    email = it
//                },
//                label = {
//                    Text(text = "Email")
//                }
//            )
//        }
//        Column(modifier = Modifier.padding(16.dp)) {
//            Row(verticalAlignment = Alignment.CenterVertically) {
//                Icon(
//                    imageVector = Icons.Outlined.Lock,
//                    contentDescription = "User Password",
//                    tint = Color.Gray,
//                    modifier = Modifier.size(16.dp)
//                )
//                Spacer(modifier = Modifier.width(8.dp))
//                Text(
//                    text = "Your Password",
//                    color = Color.Gray,
//                    fontSize = 14.sp
//                )
//            }
//
//            Spacer(modifier = Modifier.height(4.dp))
//
//            OutlinedTextField(
//                modifier = Modifier.fillMaxWidth(),
//                value = password,
//                onValueChange = {
//                    password = it
//                },
//                label = {
//                    Text(text = "Password")
//                }
//            )
//        }
//        Button(
//            onClick = {
//                authViewModel.signup1(email, password, navController)
//            },
//            enabled = authState.value != AuthState.Loading
//        ) {
//            Text(text = "Create account")
//        }
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        TextButton(onClick = {
//            navController.navigate("login")
//        }) {
//            Text(text = "Already have an account, Login")
//        }
//
//    }
//}