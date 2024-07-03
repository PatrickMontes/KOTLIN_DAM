package com.cibertec.bembos.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Category (
    @SerializedName("id")
    @Expose
    var id: Int = 0,
    @SerializedName("nombre")
    @Expose
    var nombre: String? = null
)
