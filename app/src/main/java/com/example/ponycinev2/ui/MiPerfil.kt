package com.example.ponycinev2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.ponycinev2.R
import com.example.ponycinev2.adapters.TiketsAdapter
import com.example.ponycinev2.databinding.MiPerfilFragmentBinding
import com.example.ponycinev2.models.Compra

class MiPerfil : Fragment() {

    private val viewModel: GlobalViewModel by activityViewModels()

    private var _binding: MiPerfilFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MiPerfilFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getBD.observe(viewLifecycleOwner, Observer {
            binding.lvTikets.adapter = TiketsAdapter(requireView().context, R.layout.tiket, it.compras)
        })
    }

}