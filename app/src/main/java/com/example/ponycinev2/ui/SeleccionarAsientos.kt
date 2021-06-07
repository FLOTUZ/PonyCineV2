package com.example.ponycinev2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
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
        binding.silla1.setOnClickListener {
            binding.silla1.setImageResource(R.drawable.silla_seleccionada)
            viewModel.addAsientosSeleccionado(1)
        }
        binding.silla2.setOnClickListener {
            binding.silla2.setImageResource(R.drawable.silla_seleccionada)
            viewModel.addAsientosSeleccionado(2)
        }
        binding.silla3.setOnClickListener {
            binding.silla3.setImageResource(R.drawable.silla_seleccionada)
            viewModel.addAsientosSeleccionado(3)
        }
    }

}