package com.cibertec.bembos.Activity


import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cibertec.bembos.R
import com.cibertec.bembos.adapter.AdapterCategoria

import com.cibertec.bembos.models.Category
import com.cibertec.bembos.remote.ApiUtil
import com.cibertec.bembos.service.CategoryService

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MenuActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private var categoriaService: CategoryService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        listView = findViewById(R.id.listCategoria)
        categoriaService = ApiUtil.categoriaService

        fetchCategories()
    }

    private fun fetchCategories() {
        val call: Call<List<Category>> = categoriaService!!.getCategory()
        call.enqueue(object : Callback<List<Category>> {
            override fun onResponse(call: Call<List<Category>>, response: Response<List<Category>>) {
                if (response.isSuccessful) {
                    val categories: List<Category> = response.body()!!
                    val adapter = AdapterCategoria(this@MenuActivity, categories)
                    listView.adapter = adapter
                } else {
                    Toast.makeText(this@MenuActivity, "Error al obtener categorías", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Category>>, t: Throwable) {
                Toast.makeText(this@MenuActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}