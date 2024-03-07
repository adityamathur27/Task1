package com.example.task1

import com.example.task1.data.data_class
import com.example.task1.data.data_classItem
import retrofit2.Call
import retrofit2.http.GET

interface apiInterface {
    @GET("/users")
    fun showData() : Call<List<data_classItem>>
}