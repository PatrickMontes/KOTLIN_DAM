package com.example.myapp.models

import com.cibertec.bembos.models.Product
import com.example.myapp.models.Order
import com.example.myapp.models.*

data class OrderDetails(
    val id: Int?,
    val cantidad: Int?,
    val precioUni: Double?,
    val order: Order?,
    val idProducto: Product?
)
