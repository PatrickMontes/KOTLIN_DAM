package com.cibertec.bembos.models

data class Department(
    val id: Int,
    val name: String
) {
    override fun toString(): String {
        return name
    }
}