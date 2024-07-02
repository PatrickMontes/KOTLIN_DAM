package com.cibertec.bembos.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Category {
    @SerializedName("id")
    @Expose
    private var id = 0
    @SerializedName("nombre")
    @Expose
    private var nombre: String? = null

    /**CONSTRUCTORES */
    fun Category() {}
    fun Category(id: Int, nombre: String?) {
        this.id = id
        this.nombre = nombre
    }

    /**GETTERS Y SETTERS */
    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getNombre(): String? {
        return nombre
    }

    fun setNombre(nombre: String?) {
        this.nombre = nombre
    }
}