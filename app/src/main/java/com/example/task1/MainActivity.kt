package com.example.task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task1.Adapter.RecyclerViewAdapter
import com.example.task1.data.data_class
import com.example.task1.data.data_classItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerViewAdapter(ArrayList())
        recyclerView.adapter = adapter
        fetchData()


    }
    private fun fetchData(){
        val apiService : apiInterface = RetrofitClient.retrofit.create(apiInterface::class.java)
        val call : Call<List<data_classItem>> = apiService.showData()

        call.enqueue(object : Callback<List<data_classItem>>{
            override fun onResponse(
                call: Call<List<data_classItem>>,
                response: Response<List<data_classItem>>
            ) {
                if (response.isSuccessful) {
                    val users: List<data_classItem>? = response.body()
                    if (users != null) {
                        val userList = ArrayList(users)
                        adapter.updateData(userList)

                    }
                } else {
                    // Handle unsuccessful response
                    println("Error: ${response.code()}")
                }
            }
            override fun onFailure(call: Call<List<data_classItem>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })


    }
}

