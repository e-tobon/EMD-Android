package com.avv.cardiologoapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.avv.cardiologoapp.R
import com.avv.cardiologoapp.databinding.FragmentHistorialClinicoBinding


class HistorialClinicoFragment : Fragment(R.layout.fragment_historial_clinico) {

    private lateinit var binding: FragmentHistorialClinicoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHistorialClinicoBinding.bind(view)

        binding.btnElectrocariograma.setOnClickListener {
            findNavController().navigate(R.id.action_historialClinicoFragment_to_resultCardioFragment)
        }

    }


}