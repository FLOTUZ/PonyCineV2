package com.example.ponycinev2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.ponycinev2.R
import com.example.ponycinev2.models.Compra

class TiketsAdapter(val context: Context, val layout: Int, val lista: ArrayList<Compra>):BaseAdapter() {
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

        val img = miView.findViewById<ImageView>(R.id.imgTiket)
        val nombre = miView.findViewById<TextView>(R.id.lblNombrePeliculaTiket)
        val fecha = miView.findViewById<TextView>(R.id.lblFechaPeliculaTiket)
        val hora = miView.findViewById<TextView>(R.id.lblHoraPeliculaTiket)

        img.setImageResource(lista[position].pelicula.img)
        nombre.text = lista[position].pelicula.nombre
        hora.text = lista[position].hora
        fecha.text = lista[position].fecha


        return miView
    }
}