package com.devpiyush07.retrofitrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.devpiyush07.retrofitrecycler.Api.ApiInterface
import com.devpiyush07.retrofitrecycler.DataClass.UsersDataItem
import com.devpiyush07.retrofitrecycler.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val baseurl = "https://api.github.com/"
    private lateinit var mAdapter: UserDataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        setContentView(binding.root)

        Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
            .getUserData()
            .enqueue(object : Callback<List<UsersDataItem>>{
                override fun onResponse(
                    call: Call<List<UsersDataItem>>,
                    response: Response<List<UsersDataItem>>
                ) {
                    val users = response.body()!!
                    Log.d("UserVal",users.toString())
                    mAdapter = UserDataAdapter(applicationContext,users)
                    binding.recyclerView.adapter = mAdapter
                }

                override fun onFailure(call: Call<List<UsersDataItem>>, t: Throwable) {
                    Log.d("UserVal",t.message.toString())
                }
            })
    }
}