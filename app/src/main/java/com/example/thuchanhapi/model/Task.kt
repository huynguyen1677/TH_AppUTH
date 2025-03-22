package com.example.thuchanhapi.model

// Data Class for the root of the JSON response
data class TaskResponse(
    val isSuccess: Boolean,
    val message: String,
    val data: List<Task>
)

// Data Class for each task
data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val status: String,
    val priority: String,
    val category: String,
    val dueDate: String,
    val createdAt: String,
    val updatedAt: String,
    val subtasks: List<Subtask>,
    val attachments: List<Attachment>,
    val reminders: List<Reminder>
)

// Data Class for subtasks
data class Subtask(
    val id: Int,
    val title: String,
    val isCompleted: Boolean
)

// Data Class for attachments
data class Attachment(
    val id: Int,
    val fileName: String,
    val fileUrl: String
)

// Data Class for reminders
data class Reminder(
    val id: Int,
    val time: String,
    val type: String
)
