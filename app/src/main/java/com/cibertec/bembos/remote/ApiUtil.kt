package com.cibertec.bembos.remote

import com.cibertec.bembos.service.*;
import com.example.myapp.api.ClientService

object ApiUtil {
    val API_URL = "http://192.168.56.1:9090/"

    val categoriaService: CategoryService? get() = RetrofitClient.getClient(API_URL)?.create(CategoryService::class.java)
    val clientService: ClientService? get() = RetrofitClient.getClient(API_URL)?.create(ClientService::class.java)
    val departmentService: DepartmentService? get() = RetrofitClient.getClient(API_URL)?.create(DepartmentService::class.java)
    val districtService: DistrictService? get() = RetrofitClient.getClient(API_URL)?.create(DistrictService::class.java)
    val provinceService: ProvinceService? get() = RetrofitClient.getClient(API_URL)?.create(ProvinceService::class.java)
}