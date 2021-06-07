package com.example.ponycinev2.models


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Exibicion(
    @SerializedName("fecha")
    val fecha: String,
    @SerializedName("hora")
    val hora: String
):Serializable