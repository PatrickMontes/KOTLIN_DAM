package com.example.myapp.api

import com.example.myapp.models.Client
import com.cibertec.bembos.models.Department
import com.cibertec.bembos.models.District
import com.cibertec.bembos.models.Province
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ClientService {

    @POST("api/client/createClient")
    fun createClient(@Body client: Client): Call<Client>

    @GET("api/tipoDocumento")
    fun getTipoDocumento(): Call<List<String>>

    @GET("api/departamento")
    fun getDepartamentos(): Call<List<Department>>

    @GET("api/provincia")
    fun getProvincias(): Call<List<Province>>

    @GET("api/distrito")
    fun getDistritos(): Call<List<District>>

    @POST("api/client/signin")
    fun signin(@Body client: Client): Call<String>
}
