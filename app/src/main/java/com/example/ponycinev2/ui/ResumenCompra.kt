package com.example.ponycinev2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.ponycinev2.R
import com.example.ponycinev2.databinding.ResumenCompraFragmentBinding
import com.example.ponycinev2.models.Compra
import com.example.ponycinev2.models.Exibicion
import com.example.ponycinev2.models.Pelicula

class ResumenCompra : Fragment() {

    private val viewModel: GlobalViewModel by activityViewModels()

    private var _binding: ResumenCompraFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ResumenCompraFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getPeliculaseleccionada.observe(viewLifecycleOwner, Observer {
            binding.imagenPeliculaResumen.setImageResource(it.img)
            binding.nombrePeliculaResumen.text = it.nombre
        })

        viewModel.getHorarioSeleccionado.observe(viewLifecycleOwner, Observer {
            binding.horaResumen.text = it.hora
            binding.fechaResumen.text = it.fecha
        })

        viewModel.getAsientosSeleccionados.observe(viewLifecycleOwner, Observer {
            binding.asientosResumen.text = it.toString()
        })

        binding.verBoletos.setOnClickListener {

            viewModel.getPeliculaseleccionada.observe(viewLifecycleOwner, Observer { peli ->
                viewModel.getHorarioSeleccionado.observe(viewLifecycleOwner, Observer { exibicion ->
                    viewModel.getAsientosSeleccionados.observe(viewLifecycleOwner, Observer { asientos ->
                        viewModel.addTiket(Compra(0,peli,asientos, exibicion.hora, exibicion.fecha))
                    })
                })
            })

            findNavController().navigate(R.id.action_resumenCompra_to_miPerfil)
        }
    }

}