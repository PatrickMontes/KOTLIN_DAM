package com.example.myapp.api

import com.example.myapp.models.Client
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ClientService {

    @GET("/api/client/list")
    fun getAllClients(): Call<List<Client>>

    @POST("/api/client/signin")
    fun signin(@Body newCli: Client): Call<String>

    @POST("/api/client/createClient")
    fun createClient(@Body newCli: Client): Call<Client>
}
