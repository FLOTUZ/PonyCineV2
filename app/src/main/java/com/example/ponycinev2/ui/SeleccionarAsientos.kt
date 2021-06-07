package com.example.ponycinev2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ponycinev2.R
import com.example.ponycinev2.databinding.CarteleraFragmentBinding
import com.example.ponycinev2.databinding.SeleccionarAsientosFragmentBinding

class SeleccionarAsientos : Fragment() {

    private val viewModel: GlobalViewModel by activityViewModels()

    private var _binding: SeleccionarAsientosFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SeleccionarAsientosFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getPeliculaseleccionada.observe(viewLifecycleOwner, Observer {
            binding.tituloPelicula.text = it.nombre
        })

        val asientos = ArrayList<Int>()

        var asiento1 = false
        var asiento2 = false
        var asiento3 = false

        binding.silla1.setOnClickListener {
            if (!asiento1) {
                binding.silla1.setImageResource(R.drawable.silla_seleccionada)
                asiento1 = true
                asientos.add(1)
                viewModel.setAsientosSeleccionados(asientos)
                viewModel.getAsientosSeleccionados.observe(viewLifecycleOwner, Observer {
                    println(it)
                })
            } else {
                binding.silla1.setImageResource(R.drawable.silla)
                asiento1 = false
                asientos.remove(1)
                viewModel.setAsientosSeleccionados(asientos)
                viewModel.getAsientosSeleccionados.observe(viewLifecycleOwner, Observer {
                    println(it)
                })
            }
        }
        binding.silla2.setOnClickListener {
            if (!asiento2) {
                binding.silla2.setImageResource(R.drawable.silla_seleccionada)
                asiento2 = true
                asientos.add(2)
                viewModel.setAsientosSeleccionados(asientos)
                viewModel.getAsientosSeleccionados.observe(viewLifecycleOwner, Observer {
                    println(it)
                })
            } else {
                binding.silla2.setImageResource(R.drawable.silla)
                asiento2 = false
                asientos.remove(2)
                viewModel.setAsientosSeleccionados(asientos)
                viewModel.getAsientosSeleccionados.observe(viewLifecycleOwner, Observer {
                    println(it)
                })
            }
        }
        binding.silla3.setOnClickListener {
            if (!asiento3) {
                binding.silla3.setImageResource(R.drawable.silla_seleccionada)
                asiento3 = true
                asientos.add(3)
                viewModel.setAsientosSeleccionados(asientos)
                viewModel.getAsientosSeleccionados.observe(viewLifecycleOwner, Observer {
                    println(it)
                })
            } else {
                binding.silla3.setImageResource(R.drawable.silla)
                asiento3 = false
                asientos.remove(3)
                viewModel.setAsientosSeleccionados(asientos)
                viewModel.getAsientosSeleccionados.observe(viewLifecycleOwner, Observer {
                    println(it)
                })
            }
        }

    }
}