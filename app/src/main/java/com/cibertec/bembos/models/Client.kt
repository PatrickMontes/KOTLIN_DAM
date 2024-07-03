package com.example.myapp.models

import com.cibertec.bembos.models.*

data class Client(
    var id: Int? = null,
    var nombre: String? = null,
    var ape_paterno: String? = null,
    var ape_materno: String? = null,
    var tipodocumento: String? = null,
    var numdocumento: String? = null,
    var direccion: String? = null,
    var telefono: String? = null,
    var email: String? = null,
    var clave: String? = null
)