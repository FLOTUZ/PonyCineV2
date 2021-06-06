package com.example.ponycinev2.models


import com.google.gson.annotations.SerializedName

data class Exibicion(
    @SerializedName("fecha")
    val fecha: String,
    @SerializedName("hora")
    val hora: String
)