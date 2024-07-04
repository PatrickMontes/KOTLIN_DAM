package com.cibertec.bembos.Activity


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.bembos.R
import com.cibertec.bembos.adapter.AdapterCategoria
import com.cibertec.bembos.adapter.ProductAdapter

import com.cibertec.bembos.models.Category
import com.cibertec.bembos.models.Product
import com.cibertec.bembos.remote.ApiUtil
import com.cibertec.bembos.service.CategoryService

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MenuActivity : AppCompatActivity() {


    private lateinit var categoryRecyclerView: RecyclerView
    private lateinit var categoryAdapter: AdapterCategoria
    private val categories = mutableListOf<Category>()
    private lateinit var productRecyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter
    private val products = mutableListOf<Product>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        categoryRecyclerView = findViewById(R.id.listCategoria)
        categoryAdapter = AdapterCategoria(categories)
        categoryRecyclerView.adapter = categoryAdapter
        categoryRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        productRecyclerView = findViewById(R.id.listProducts) // Asegúrate de que listProductos sea el RecyclerView correcto
        productAdapter = ProductAdapter(products)
        productRecyclerView.adapter = productAdapter
        productRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        fetchProducts()

        fetchCategories()
    }

    private fun fetchCategories() {
        val categoryService = ApiUtil.categoriaService
        categoryService?.getCategory()?.enqueue(object : Callback<List<Category>> {
            override fun onResponse(call: Call<List<Category>>, response: Response<List<Category>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        categories.clear()
                        categories.addAll(it)
                        categoryAdapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<List<Category>>, t: Throwable) {
                Log.e("MenuActivity", "Error fetching categories", t)
            }
        })
    }



    private fun fetchProducts() {
        val productService = ApiUtil.productService
        productService?.getProducts()?.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        products.clear()
                        products.addAll(it)
                        productAdapter.notifyDataSetChanged()
                    }
                } else {
                    Toast.makeText(this@MenuActivity, "Error loading products", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Log.e("MenuActivity", "Error fetching products", t)
            }
        })
    }



}