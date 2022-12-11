package com.example.viewmodel.retrofit

import com.example.viewmodel.data.Countries
import retrofit2.Call
import retrofit2.http.GET

interface RetroServiceInterface {
    @GET("all")
    fun getListOfData():Call<List<Countries>>
}