package com.devpiyush07.retrofitrecycler.Api

import com.devpiyush07.retrofitrecycler.DataClass.UsersDataItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/users")
    fun getUserData() : Call<List<UsersDataItem>>
}