package com.example.ponycinev2.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.ponycinev2.R
import com.example.ponycinev2.databinding.AlimentosFragmentBinding

class Alimentos : Fragment() {

    private val viewModel: GlobalViewModel by activityViewModels()

    private var _binding: AlimentosFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AlimentosFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button2.setOnClickListener {
            binding.button2.setOnClickListener {

                viewModel.getBD.observe(viewLifecycleOwner, Observer {
                    println(it)
                })

            }
        }
    }

}