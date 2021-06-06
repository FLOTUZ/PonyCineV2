package com.example.ponycinev2.models


import com.google.gson.annotations.SerializedName

data class Pelicula(
    @SerializedName("id")
    val id: Int,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("img")
    val img: Int,
    @SerializedName("exibicion")
    val exibicion: ArrayList<Exibicion>
)