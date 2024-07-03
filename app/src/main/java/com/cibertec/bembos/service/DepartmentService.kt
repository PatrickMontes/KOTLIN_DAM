package com.cibertec.bembos.service

import com.cibertec.bembos.models.Department
import retrofit2.Call
import retrofit2.http.GET

interface DepartmentService {
    @GET("api/departmen/list")
    fun getDepartments(): Call<List<Department>>
}