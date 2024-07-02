package com.example.myapp.models

import com.cibertec.bembos.models.*

data class Client(
    val id: Int?,
    val nombre: String?,
    val ape_paterno: String?,
    val ape_materno: String?,
    val tipodocumento: String?,
    val numdocumento: String?,
    val direccion: String?,
    val departamento_id: Department?,
    val provincia_id: Province?,
    val distrito_id: District?,
    val telefono: String?,
    val email: String?,
    val clave: String?
)
