package com.example.thuchanhapi.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thuchanhapi.R
import com.example.thuchanhapi.ui.theme.Blue_text

@Preview(showBackground = true)
@Composable
fun HeaderHome(modifier: Modifier = Modifier, ){
    Row(
        Modifier
            .fillMaxWidth()
            .padding(top = 40.dp, start = 8.dp, end = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.uth_logo),
            contentDescription = "Logo UTH",
            Modifier.size(80.dp)
        )

        Column(Modifier.weight(1f).padding(start = 8.dp)) {
            Text(
                text = "SmartTasks",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Blue_text
            )
            Text(
                text = "A simple and efficient to-do app",
                fontSize = 13.sp,
                color = Blue_text
            )
        }

        Image(
            painter = painterResource(id = R.drawable.no),
            contentDescription = "Thông báo",
            Modifier
                .size(36.dp)



        )
    }
}