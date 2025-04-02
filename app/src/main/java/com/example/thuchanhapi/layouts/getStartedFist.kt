package com.example.thuchanhapi.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
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
import com.example.thuchanhapi.R

@Composable
fun GetStartedFist(modifier: Modifier = Modifier,navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

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
                        .background(Color.Blue, RoundedCornerShape(50))
                )
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(Color.LightGray, RoundedCornerShape(50))
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
                modifier = Modifier.clickable { navController.navigate("login") }
            )
        }

        Spacer(modifier = Modifier.height(50.dp))

        // Main content
        Image(
            painter = painterResource(id = R.drawable.page1),
            contentDescription = "Easy Time Management",
            modifier = Modifier.size(250.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text("Easy Time Management", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "With management based on priority and daily tasks, it will give you convenience in managing and determining the tasks that must be done first.",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.weight(1f))

        // Next button
        Button(
            onClick = { navController.navigate("page3") },
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(Color.Blue),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Next", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}

