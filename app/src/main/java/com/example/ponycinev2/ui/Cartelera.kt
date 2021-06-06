package com.example.ponycinev2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ponycinev2.R
import com.example.ponycinev2.adapters.CarteleraAdapter
import com.example.ponycinev2.databinding.CarteleraFragmentBinding
import com.example.ponycinev2.models.Pelicula

class Cartelera : Fragment() {

    private val viewModel: GlobalViewModel by activityViewModels()

    private var _binding: CarteleraFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CarteleraFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getBD.observe(viewLifecycleOwner, {
            val pelis = it.peliculas

            binding.rvCartelera.adapter =
                object : CarteleraAdapter(view.context, pelis, R.layout.pelicula_card) {
                    override fun verHorarios(pelicula: Pelicula) {
                        viewModel.setPeliculaSeleccionada(pelicula)
                        findNavController().navigate(R.id.action_cartelera_to_horariosPelicula)
                    }
                }

            binding.rvCartelera.layoutManager = GridLayoutManager(view.context, 3)
        })


    }


}