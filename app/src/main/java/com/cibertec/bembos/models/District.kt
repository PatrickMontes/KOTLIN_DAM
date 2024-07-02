package com.example.myapp.models

data class District(
    val id: Int?,
    val nombre: String?,
    val provincia_id: Province?  // Relación con Province
)
