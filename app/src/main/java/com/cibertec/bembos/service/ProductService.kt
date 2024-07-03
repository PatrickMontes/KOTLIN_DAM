package com.cibertec.bembos.service

import com.cibertec.bembos.models.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {

    @GET("/api/products/list")
    fun getProducts(): Call<List<Product>>

}