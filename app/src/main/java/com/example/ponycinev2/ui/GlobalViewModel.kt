package com.example.ponycinev2.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ponycinev2.models.Compra
import com.example.ponycinev2.models.DataBase
import com.example.ponycinev2.models.Pelicula

class GlobalViewModel : ViewModel() {
    private val dataBase = MutableLiveData<DataBase>()

    val getBD: LiveData<DataBase> get() = dataBase
    val getPeliculas: ArrayList<Pelicula> get() = dataBase.value!!.peliculas
    val getCompras: ArrayList<Compra> get() = dataBase.value!!.compras

    fun setBD(bd: DataBase) {
        dataBase.value = bd
    }

    fun addPeliculas(peliculas: ArrayList<Pelicula>){
        for(i in peliculas){
            dataBase.value?.peliculas?.add(i)
        }
    }

    fun addCompra(compra: Compra){
        dataBase.value?.compras?.add(compra)
    }
}