package com.example.ponycinev2.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ponycinev2.models.Compra
import com.example.ponycinev2.models.DataBase
import com.example.ponycinev2.models.Exibicion
import com.example.ponycinev2.models.Pelicula

class GlobalViewModel : ViewModel() {
    //-----------------------Base de datos----------------------------------------
    private val dataBase = MutableLiveData<DataBase>()
    //-----------------------Datos de pelicula------------------------------------
    private val peliculaSeleccionada = MutableLiveData<Pelicula>()
    private val horarioSeleccionado = MutableLiveData<Exibicion>()
    private val asientosSeleccionados = MutableLiveData<ArrayList<Int>>()

    //-----------------------Getters de las 'tablas' y la BD----------------------
    val getBD: LiveData<DataBase> get() = dataBase
    val getPeliculas: ArrayList<Pelicula> get() = dataBase.value!!.peliculas
    val getCompras: ArrayList<Compra> get() = dataBase.value!!.compras

    //------------Getters de las preferencias de seleccion de la funcion---------
    val getPeliculaseleccionada: LiveData<Pelicula> get() = peliculaSeleccionada
    val getHorarioSeleccionado: LiveData<Exibicion> get() = horarioSeleccionado
    val getAsientosSeleccionados: LiveData<ArrayList<Int>> get() = asientosSeleccionados

    fun setAsientosSeleccionados(asiento: ArrayList<Int>){
        asientosSeleccionados.value = asiento
    }
    fun setHorarioSeleccioado (horario: Exibicion){
        horarioSeleccionado.value = horario
    }
    fun getTiketById(id:Int): Compra? {
        //Se consulta el tiket respecto al id
        return dataBase.value?.compras?.get(id)
    }

    fun addTiket(compra: Compra) {
        //Se agrega a la base de datos
        dataBase.value!!.compras.add(compra)
    }

    fun setBD(bd: DataBase) {
        dataBase.value = bd
    }

    fun addPeliculas(peliculas: ArrayList<Pelicula>) {
        for (i in peliculas) {
            dataBase.value?.peliculas?.add(i)
        }
    }

    fun setPeliculaSeleccionada(pelicula: Pelicula) {
        peliculaSeleccionada.value = pelicula
    }
}