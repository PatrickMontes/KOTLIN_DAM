package com.cibertec.bembos.service

import com.cibertec.bembos.models.District
import retrofit2.Call
import retrofit2.http.GET

interface DistrictService {
    @GET("api/district/list")
    fun getDistricts(): Call<List<District>>
}