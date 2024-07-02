package com.cibertec.bembos.service

import com.cibertec.bembos.models.Category
import retrofit2.Call
import retrofit2.http.GET

interface CategoryService {

    @GET("/api/category/list")
    fun getCategory(): Call<List<Category>>



}