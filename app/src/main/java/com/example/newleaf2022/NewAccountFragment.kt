package com.example.newleaf2022

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels

import com.example.newleaf2022.databinding.FragmentNewAccountBinding
import com.example.newleaf2022.models.dataclasses.Accounts
import com.example.newleaf2022.viewmodels.BudgetsViewModel

class NewAccountFragment : Fragment() {

    private lateinit var binding: FragmentNewAccountBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewAccountBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainActivity = (context as MainActivity)


        binding.btnAddAcctCancel.setOnClickListener {
            mainActivity.changeFragment("main", AccountsFragment())
        }

        binding.btnAddAcctConfirm.setOnClickListener {
            val newAccount = Accounts(binding.tvAcctInitialNickname.text.toString(), binding.tvAcctInitialType.text.toString(), binding.tvAcctInitialBalance.text.toString().toDouble())
            mainActivity.getInstanceOfViewModel().addNewAccount(newAccount)
            mainActivity.changeFragment("main", AccountsFragment())
        }
    }
}