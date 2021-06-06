package com.example.ponycinev2.models


import com.google.gson.annotations.SerializedName

data class DataBase(
    @SerializedName("peliculas")
    val peliculas: ArrayList<Pelicula>,
    @SerializedName("compras")
    val compras: ArrayList<Compra>
)