package com.example.newleaf2022

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels

import com.example.newleaf2022.databinding.FragmentNewAccountBinding
import com.example.newleaf2022.dataclasses.Accounts
import com.example.newleaf2022.viewmodels.BudgetsViewModel

class NewAccountFragment : Fragment() {

    private var fragmentBinding: FragmentNewAccountBinding? = null
    private val binding get() = fragmentBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentBinding = FragmentNewAccountBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val budgetsVM: BudgetsViewModel by activityViewModels()
        val mainActivity = (context as MainActivity)

        //
        binding.btnCancelNewAccount.setOnClickListener {
            mainActivity.changeFragment("main", AccountsFragment())
        }

        binding.btnAddAcount.setOnClickListener {

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentBinding = null
    }

}