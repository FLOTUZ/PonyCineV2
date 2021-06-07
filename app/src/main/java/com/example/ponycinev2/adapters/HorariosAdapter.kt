package com.example.ponycinev2.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.ponycinev2.R
import com.example.ponycinev2.models.Exibicion
import com.example.ponycinev2.models.Pelicula

abstract class HorariosAdapter(val context: Context, val layout: Int, val lista: ArrayList<Exibicion>) :
    BaseAdapter() {
    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(position: Int): Any {
        return lista[position]
    }

    override fun getItemId(position: Int): Long {
        return -1
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val miView = inflater.inflate(layout, null)

        val hora = miView.findViewById<TextView>(R.id.horaExibicion)
        val fecha = miView.findViewById<TextView>(R.id.fechaExibicion)
        val card = miView.findViewById<CardView>(R.id.cardSelected)

        hora.text = lista[position].hora
        fecha.text = lista[position].fecha

        card.setOnClickListener {
            val exibicion = Exibicion(lista[position].fecha, lista[position].hora)
            seleccionarHorario(exibicion)
        }
        return miView
    }

    abstract fun seleccionarHorario(horario : Exibicion)
}