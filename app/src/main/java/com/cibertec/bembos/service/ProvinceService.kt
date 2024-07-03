package com.cibertec.bembos.service

import com.cibertec.bembos.models.Province
import retrofit2.Call
import retrofit2.http.GET

interface ProvinceService {
    @GET("api/province/list")
    fun getProvinces(): Call<List<Province>>
}
