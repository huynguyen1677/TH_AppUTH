package com.example.thuchanhapi.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.clickable
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.ui.res.colorResource
import com.example.thuchanhapi.R

@Composable
fun GetStartedSecond(modifier: Modifier = Modifier,navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top section: Dots Indicator + Skip button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(Color.LightGray, RoundedCornerShape(50))
                )
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(Color.Blue, RoundedCornerShape(50))
                )
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(Color.LightGray, RoundedCornerShape(50))
                )
            }

            Text(
                text = "Skip",
                fontSize = 16.sp,
                color = Color.Blue,
                modifier = Modifier.clickable { navController.navigate("home") }
            )
        }

        Spacer(modifier = Modifier.height(50.dp))

        Image(
            painter = painterResource(id = R.drawable.page2),
            contentDescription = "Increase Work Effectiveness",
            modifier = Modifier.size(250.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text("Increase Work Effectiveness", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "Time management and the determination of more important tasks will give your job statistics better and always improve.",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "Back",
                modifier = Modifier
                    .size(30.dp) // Kích thước lớn hơn
                    .clickable { navController.navigate("page2") },
                tint = Color.Black

            )

            Button(
                onClick = { navController.navigate("page4") },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(Color.Blue),
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(50.dp)
            ) {
                Text("Next", fontSize = 18.sp)
            }
        }
    }
}