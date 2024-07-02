package com.cibertec.bembos.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Product {
    @SerializedName("id")
    @Expose
    private var id = 0
    @SerializedName("nombre")
    @Expose
    private var nombre: String? = null
    @SerializedName("categoria_id")
    @Expose
    private var category: Category? = null
    @SerializedName("descripcion")
    @Expose
    private var descripcion: String? = null
    @SerializedName("stock")
    @Expose
    private var stock = 0
    @SerializedName("precio")
    @Expose
    private var precio = 0.0
    @SerializedName("foto_url")
    @Expose
    private var foto_url: String? = null

    fun Product() {}
    fun Product(
        id: Int,
        nombre: String?,
        category: Category?,
        descripcion: String?,
        stock: Int,
        precio: Double,
        foto_url: String?
    ) {
        this.id = id
        this.nombre = nombre
        this.category = category
        this.descripcion = descripcion
        this.stock = stock
        this.precio = precio
        this.foto_url = foto_url
    }

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

    fun getCategory(): Category? {
        return category
    }

    fun setCategory(category: Category?) {
        this.category = category
    }

    fun getDescripcion(): String? {
        return descripcion
    }

    fun setDescripcion(descripcion: String?) {
        this.descripcion = descripcion
    }

    fun getStock(): Int {
        return stock
    }

    fun setStock(stock: Int) {
        this.stock = stock
    }

    fun getPrecio(): Double {
        return precio
    }

    fun setPrecio(precio: Double) {
        this.precio = precio
    }

    fun getFoto_url(): String? {
        return foto_url
    }

    fun setFoto_url(foto_url: String?) {
        this.foto_url = foto_url
    }
}