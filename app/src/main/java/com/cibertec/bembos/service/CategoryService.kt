package com.cibertec.bembos.service;



import com.cibertec.bembos.models.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoryService {
    @GET("/api/category/list")
    Call<List<Category>> getCategory();
}
