package com.example.ponycinev2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ponycinev2.databinding.ResumenCompraFragmentBinding

class ResumenCompra : Fragment() {

    private lateinit var viewModel: GlobalViewModel

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



}