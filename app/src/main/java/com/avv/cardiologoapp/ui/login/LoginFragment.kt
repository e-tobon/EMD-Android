package com.avv.cardiologoapp.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.avv.cardiologoapp.R
import com.avv.cardiologoapp.databinding.FragmentLoginBinding
import com.avv.cardiologoapp.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var auth: FirebaseAuth

    private lateinit var binding: FragmentLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if(email.isEmpty()){
                Toast.makeText(requireContext(),"Ingresa un email", Toast.LENGTH_SHORT).show()
            }


            if(!email.isEmpty() and !password.isEmpty()){
                loginEmai(email,password)
            }



        }

        binding.tvCrearCuenta.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

    }


    private fun loginEmai( email:String, password:String){

        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
                    findNavController().navigate(R.id.action_loginFragment_to_historialClinicoFragment)
                }else{
                    Toast.makeText(requireContext(),"No tienes cuenta?, Crea una para continuar...", Toast.LENGTH_LONG).show()
                }
            }
    }
}