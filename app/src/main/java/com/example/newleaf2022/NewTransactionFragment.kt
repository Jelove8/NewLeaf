package com.example.newleaf2022

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newleaf2022.databinding.FragmentNewTransactionBinding

class NewTransactionFragment : Fragment() {

    private var fragmentBinding: FragmentNewTransactionBinding? = null
    private val binding get() = fragmentBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentBinding = FragmentNewTransactionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCancelTransaction.setOnClickListener {

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentBinding = null
    }

}