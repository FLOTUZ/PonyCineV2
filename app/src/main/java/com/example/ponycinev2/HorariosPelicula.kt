package com.example.ponycinev2

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class HorariosPelicula : Fragment() {

    companion object {
        fun newInstance() = HorariosPelicula()
    }

    private lateinit var viewModel: HorariosPeliculaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.horarios_pelicula_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HorariosPeliculaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}