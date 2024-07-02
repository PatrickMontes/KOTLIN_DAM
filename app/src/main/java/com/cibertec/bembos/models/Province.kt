package com.example.myapp.models

data class Province(
    val id: Int?,
    val nombre: String?,
    val department_id: Department?  // Relación con Department
)
