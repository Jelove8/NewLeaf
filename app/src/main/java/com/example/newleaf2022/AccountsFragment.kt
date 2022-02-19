package com.example.newleaf2022

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newleaf2022.adapters.AccountsAdapter
import com.example.newleaf2022.databinding.FragmentAccountsBinding
import com.example.newleaf2022.dataclasses.Accounts
import com.example.newleaf2022.dataclasses.Budgets
import com.example.newleaf2022.viewmodels.*

class AccountsFragment : Fragment() {

    private var fragmentBinding: FragmentAccountsBinding? = null
    private val binding get() = fragmentBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentBinding = FragmentAccountsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val budgetsVM: BudgetsViewModel by activityViewModels()
        val mainActivity = (context as MainActivity)
        binding.fragAccountsRecycler.layoutManager = LinearLayoutManager(activity)

        val currentAccounts = budgetsVM.getCurrentBudget().accounts
        binding.fragAccountsRecycler.adapter = AccountsAdapter(currentAccounts, mainActivity)

        // Button: Confirms the new account
        binding.btnAddAccount.setOnClickListener {
            mainActivity.changeFragment("main", NewAccountFragment())
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentBinding = null
    }

}