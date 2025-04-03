package com.example.thuchanhapi.pages

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import com.example.thuchanhapi.R
import com.example.thuchanhapi.model.Attachment
import com.example.thuchanhapi.model.Subtask
import com.example.thuchanhapi.ui.theme.Blue_text
import com.example.thuchanhapi.viewmodel.TaskViewModel

@Composable
fun DetailPage(modifier: Modifier = Modifier, viewModel: TaskViewModel, navController: NavController,taskID: Int) {
    val tasks = viewModel.tasks.observeAsState(initial = emptyList())
    val task = tasks.value.find { it.id == taskID }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
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
            Spacer(modifier = Modifier.weight(1f))
            Text(
                "Detail",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Blue_text,
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { /* TODO: Xóa */ }) {
                Icon(Icons.Default.Delete, contentDescription = "Delete", tint = Color.Red)
            }
        }

        Text(
            text = task?.title?: "",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = task?.description?: "",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            colors = cardColors(containerColor = Color(0xFFFFE0E0)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Row (
                modifier = Modifier.padding(16.dp)
                .fillMaxWidth()
            ) {
                TaskInfoRow(R.drawable.category,"Category", task?.category?:"")
                TaskInfoRow(R.drawable.status,"Status", task?.category?:"")
                TaskInfoRow(R.drawable.priority,"Priority", task?.priority?:"")
            }
        }

        // Subtasks
        Text(text = "Subtasks", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        task?.subtasks?.let {
            SubtaskListView(subtasks = it)
        }

        // Attachments
        Text(text = "Attachments", fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 16.dp))
        task?.attachments?.let {
            AttachmentListView(attachments = it)
        }
    }

}
@Composable
fun TaskInfoRow(image: Int,label: String, value: String) {
    Row(
        modifier = Modifier
            .width(130.dp)
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = image ),
                contentDescription = "Category",
                tint = Color.Black,
                modifier = Modifier.size(30.dp)
                    .padding(end = 8.dp)
            )
            Column {
                Text(fontSize = 14.sp, text = label,  fontWeight = FontWeight.Normal, color = Color.Black)
                Text(fontSize = 14.sp,text = value, fontWeight = FontWeight.Bold, color = Color.Black)
            }
        }

    }
}


@Composable
fun SubtaskListView(subtasks: List<Subtask>) {
    if(subtasks.isEmpty()){
        Text(text = "Subtasks is empty")
    } else {
        LazyColumn {
            items(subtasks) { subtask ->
                SubtaskItem(subtask = subtask)
            }
        }
    }

}
@Composable
fun SubtaskItem(subtask: Subtask, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = subtask.isCompleted,
            onCheckedChange = {}
        )
        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(text = subtask.title)
        }
    }
}
@Composable
fun AttachmentListView(attachments: List<Attachment>) {
    if (attachments.isEmpty()){
        Text(text = "Attachments is empty")
    } else {
        LazyColumn {
            items(attachments) { attachment ->
                AttachmentItem(attachment = attachment)
            }
        }
    }
}
@Composable
fun AttachmentItem(attachment: Attachment, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Card(
        modifier = modifier
            .clickable {
                val intent = Intent(Intent.ACTION_VIEW, attachment.fileUrl.toUri())
                context.startActivity(intent)
            }
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = attachment.fileName,)
        }
    }
}
