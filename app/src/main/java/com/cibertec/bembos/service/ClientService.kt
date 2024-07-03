package com.example.myapp.api

import com.cibertec.bembos.models.LoginRequest
import com.cibertec.bembos.models.LoginResponse
import com.example.myapp.models.Client

import com.cibertec.bembos.models.SignInResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ClientService {

    @POST("api/client/createClient")
    fun createClient(@Body client: Client): Call<Client>

    @POST("api/client/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>
}
