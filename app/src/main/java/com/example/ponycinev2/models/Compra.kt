package com.example.ponycinev2.models


import com.google.gson.annotations.SerializedName

data class Compra(
    @SerializedName("id")
    val id: Int,
    @SerializedName("pelicula")
    val pelicula: Int,
    @SerializedName("asientos")
    val asientos: ArrayList<Int>,
    @SerializedName("hora")
    val hora: String,
    @SerializedName("fecha")
    val fecha: String
)