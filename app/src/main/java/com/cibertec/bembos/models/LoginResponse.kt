package com.cibertec.bembos.models


data class LoginResponse(
    val id: Int,
    val nombre: String,
    val ape_paterno: String,
    val ape_materno: String,
    val email: String
)