package com.example.ponycinev2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.ponycinev2.R
import com.example.ponycinev2.adapters.HorariosAdapter
import com.example.ponycinev2.databinding.CarteleraFragmentBinding
import com.example.ponycinev2.databinding.HorariosPeliculaFragmentBinding
import com.example.ponycinev2.models.Exibicion
import com.example.ponycinev2.models.Pelicula

class HorariosPelicula : Fragment() {

    private val viewModel: GlobalViewModel by activityViewModels()

    private var _binding: HorariosPeliculaFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = HorariosPeliculaFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val lvsemestre1 = binding.lvHorarios

        viewModel.getPeliculaseleccionada.observe(viewLifecycleOwner, Observer { item ->
            val lista = item.exibicion
            lvsemestre1.adapter = object : HorariosAdapter(view.context, R.layout.card_exibicion, lista){
                override fun seleccionarHorario(horario: Exibicion) {
                    viewModel.setHorarioSeleccioado(horario)
                    findNavController().navigate(R.id.action_horariosPelicula_to_seleccionarAsientos)
                }
            }
        })


    }

}