package com.avv.cardiologoapp.ui.cardioResult

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.avv.cardiologoapp.R
import com.avv.cardiologoapp.databinding.FragmentResultCardioBinding


class ResultCardioFragment : Fragment(R.layout.fragment_result_cardio) {

    private lateinit var binding: FragmentResultCardioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentResultCardioBinding.bind(view)


    }

}