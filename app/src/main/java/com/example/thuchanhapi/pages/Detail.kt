package com.example.thuchanhapi.pages

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.thuchanhapi.component.TaskListHome
import com.example.thuchanhapi.R
import com.example.thuchanhapi.ui.theme.Blue_text

@Composable
fun DetailPage(modifier: Modifier = Modifier,navController: NavController, taskId: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "Back",
                tint = Blue_text,
                modifier = Modifier
                    .size(20.dp)
                    .clickable { navController.popBackStack() }
            )

            Text(
                "Text Detail",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Blue_text,
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp, bottom = 16.dp),
                textAlign = TextAlign.Center,
            )
        }

    }
}