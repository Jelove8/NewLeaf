package com.example.newleaf2022

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.newleaf2022.databinding.FragmentEditCategoriesBinding
import com.example.newleaf2022.databinding.FragmentUserloginBinding

class UserLoginFragment: Fragment() {

    private var fragmentBinding: FragmentUserloginBinding? = null
    private val binding get() = fragmentBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentBinding = FragmentUserloginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            if (binding.etUsername.text.isNotEmpty() && binding.etPassword.text.isNotEmpty()) {
                (context as MainActivity).getInstanceOfModel().authenticateUser(binding.etUsername.text.toString(),binding.etPassword.text.toString())
            }
            else {
                Toast.makeText(context,"Both fields must be filled.",Toast.LENGTH_SHORT).show()
            }
        }
       
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentBinding = null
    }
}