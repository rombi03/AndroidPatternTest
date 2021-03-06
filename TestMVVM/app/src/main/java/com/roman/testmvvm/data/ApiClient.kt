package com.roman.testmvvm.data

import com.roman.testmvvm.model.Employee
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object ApiClient {

    private const val API_BASE_URL = "http://www.mocky.io/"

    private var servicesApiInterface:ServicesApiInterface?=null

    fun build():ServicesApiInterface?{
        var builder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
        var httpClient: OkHttpClient.Builder = OkHttpClient.Builder()

        var retrofit: Retrofit = builder.client(httpClient.build()).build()
        servicesApiInterface = retrofit.create(
            ServicesApiInterface::class.java)
        return servicesApiInterface as ServicesApiInterface
    }

    interface ServicesApiInterface{
        @GET("/v2/5e972b443000008c00b6dc60")
        fun employees(): Call<List<Employee>>
    }
}