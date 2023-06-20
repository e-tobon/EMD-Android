package com.avv.cardiologoapp.ui.cardioResult

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.avv.cardiologoapp.R
import com.avv.cardiologoapp.core.Results
import com.avv.cardiologoapp.data.remote.cardioDataSource
import com.avv.cardiologoapp.databinding.FragmentResultCardioBinding
import com.avv.cardiologoapp.presentation.CardioViewModelFactory
import com.avv.cardiologoapp.presentation.cardioViewModel
import com.avv.cardiologoapp.repository.FireBaseImp
import com.avv.cardiologoapp.repository.RetrofitClient


class ResultCardioFragment : Fragment(R.layout.fragment_result_cardio) {

    private lateinit var binding: FragmentResultCardioBinding

    private val cardioViewModel: cardioViewModel by viewModels<cardioViewModel>{
        CardioViewModelFactory(FireBaseImp(cardioDataSource(RetrofitClient.webService)))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentResultCardioBinding.bind(view)

        binding.btnActualizar.setOnClickListener {

            cardioViewModel.fetchCardioValues().observe(viewLifecycleOwner, Observer { result ->
                when(result){
                    is Results.Loading -> {

                    }
                    is Results.Success -> {

                        Log.d("LiveData", result.data.toString())

                        binding.rvCardioValues.adapter = CardioAdapter(requireContext(),result.data)
                        Toast.makeText(requireContext(), "Actualizado", Toast.LENGTH_SHORT).show()
                    }
                    is Results.Failure -> {
                        Log.d("LiveData", result.exception.toString())
                        Toast.makeText(requireContext(),result.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            })

        }
        cardioViewModel.fetchCardioValues().observe(viewLifecycleOwner, Observer { result ->
            when(result){
                is Results.Loading -> {
                    binding.progressBar.isVisible = true
                }
                is Results.Success -> {
                    binding.progressBar.isVisible = false
                    Log.d("LiveData", result.data.toString())
                    binding.rvCardioValues.adapter = CardioAdapter(requireContext(),result.data)
                }
                is Results.Failure -> {
                    Log.d("LiveData", result.exception.toString())
                    Toast.makeText(requireContext(),result.exception.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        })


    }

}