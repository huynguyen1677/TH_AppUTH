

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.thuchanhapi.R
import com.example.thuchanhapi.ui.theme.Blue_text

@Composable
fun LoginScreen(modifier: Modifier = Modifier, navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
//    val context = LocalContext.current
//    val auth = FirebaseAuth.getInstance()
//    val googleSignInClient = remember {
//        GoogleSignIn.getClient(
//            context,
//            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken("1015499092109-jseg6rhh12vk926n9kqbueqgmsei19lf.apps.googleusercontent.com")
//                .requestEmail()
//                .build()
//        )
//    }

//    val googleSignInLauncher = rememberLauncherForActivityResult(
//        contract = ActivityResultContracts.StartActivityForResult()
//    ) { result ->
//        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
//        try {
//            val account: GoogleSignInAccount = task.getResult(ApiException::class.java)
//            val credential = GoogleAuthProvider.getCredential(account.idToken, null)
//            auth.signInWithCredential(credential)
//                .addOnCompleteListener { task ->
//                    if (task.isSuccessful) {
//                        Toast.makeText(context, "Google Login Successful!", Toast.LENGTH_SHORT).show()
//                        navController.navigate("home")
//                    } else {
//                        Toast.makeText(context, "Google Login Failed!", Toast.LENGTH_SHORT).show()
//                    }
//                }
//        } catch (e: ApiException) {
//            Toast.makeText(context, "Google Sign-In Failed: ${e.message}", Toast.LENGTH_SHORT).show()
//        }
//    }

    Box(
        modifier = modifier.fillMaxSize()
    ) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {


                Text(
                    text = "Đăng nhập",
                    fontSize = 38.sp,
                    fontWeight = Bold,
                    color = Blue_text,
                )

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text(text = "Email") },
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        focusedIndicatorColor = Blue_text,
                        unfocusedIndicatorColor = Blue_text,
                        unfocusedContainerColor = Color.White,
                        unfocusedTextColor = Color.Black
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text(text = "Password") },
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        focusedIndicatorColor = Blue_text,
                        unfocusedIndicatorColor = Blue_text,
                        unfocusedContainerColor = Color.White,
                        unfocusedTextColor = Color.Black
                    )
                )
                TextButton(

                    // test navigationbottom

                    onClick = { navController.navigate("homeNav") },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(text = "Quên mật khẩu", fontSize = 16.sp, color = Blue_text)
                }

                Button(
                    onClick = {
//                        auth.signInWithEmailAndPassword(email, password)
//                            .addOnCompleteListener { task ->
//                                if (task.isSuccessful) {
//                                    Toast.makeText(context, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show()
//                                    navController.navigate("home_screen") // Điều hướng sau khi đăng nhập thành công
//                                } else {
//                                    Toast.makeText(context, "Đăng nhập thất bại!", Toast.LENGTH_SHORT).show()
//                                }
//                            }
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                        .width(250.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Blue_text,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Đăng nhập")
                }

                TextButton(onClick = { navController.navigate("register_main_screen") }) {
                    Text(text = "Chưa có tài khoản ? Đăng ký ngay")
                }
                Text(text = "OR", fontSize = 14.sp, fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.height(16.dp))

                // Social Media Icons
                Row(horizontalArrangement = Arrangement.spacedBy(18.dp)) {
                    IconButton(onClick = {
//                        googleSignInClient.signOut().addOnCompleteListener {
//                            val signInIntent = googleSignInClient.signInIntent
//                            googleSignInLauncher.launch(signInIntent)
//                        }
                    }
                    ) {
                        Image(painter = painterResource(id = R.drawable.ic_google), contentDescription = "Google")
                    }
                }
            }
        }
    }}