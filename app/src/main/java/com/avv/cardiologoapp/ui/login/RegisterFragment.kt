package com.avv.cardiologoapp.ui.login

import android.os.Binder
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.avv.cardiologoapp.R
import com.avv.cardiologoapp.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var binding:FragmentRegisterBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterBinding.bind(view)

        binding.btnRegistro.setOnClickListener{

            val email = binding.etEmailRegister.text.toString()
            val password = binding.etPasswordRegister.text.toString()
            val userName = binding.etUserName.text.toString()

            if (!email.isEmpty() and  !password.isEmpty() ){

                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Toast.makeText(requireContext(),"Ingrese un email valido", Toast.LENGTH_LONG).show()
                }
                if(password.length<6){
                    Toast.makeText(requireContext(),"Se requiete que la contraseña sea de mínimo 6 caracteres ", Toast.LENGTH_LONG).show()
                }
                if(Patterns.EMAIL_ADDRESS.matcher(email).matches() and (password.length > 5)){
                    registroUsuario(userName,email,password)
                }


            }
            else if(email.isEmpty() or password.isEmpty() or userName.isEmpty()){
                Toast.makeText(requireContext(),"Favor de llenar todos los campos", Toast.LENGTH_LONG).show()
            }

        }
    }

    private fun registroUsuario(userName:String,email:String,password:String){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {

                    Toast.makeText(
                        requireContext(),
                        "El usario $userName creado con exito!", Toast.LENGTH_SHORT
                    ).show()
                    findNavController().navigate(R.id.action_registerFragment_to_loginFragment)

                } else {
                    Toast.makeText(
                        requireContext(),
                        "Confirma que haya ingresado todo correctamente",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

    }


}