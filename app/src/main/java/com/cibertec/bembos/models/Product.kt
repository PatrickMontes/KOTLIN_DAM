package com.cibertec.bembos.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Product(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val stock: Int,
    val precio: Double,
    val foto_url: String,
    val category: Category
)