package com.example.myapp.models

import com.example.myapp.models.*
import java.util.Date

data class Order(
    val id: Int?,
    val fechaCompra: Date?,
    val montoTotal: Double?,
    val cliente_id: Client?,
    val listDetail: List<OrderDetails>?
)
