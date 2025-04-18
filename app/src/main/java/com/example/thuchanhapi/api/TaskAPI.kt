package com.example.thuchanhapi.api

import com.example.thuchanhapi.model.TaskResponse
import retrofit2.Response
import retrofit2.http.GET

interface TaskAPI {
    @GET("researchUTH/tasks")
//    @GET("researchUTH/tasks/1")
    suspend fun getTasks(): Response<TaskResponse>
}