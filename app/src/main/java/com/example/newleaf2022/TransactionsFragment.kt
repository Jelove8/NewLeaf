package com.example.newleaf2022

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.newleaf2022.adapters.TransactionAdapter
import com.example.newleaf2022.databinding.FragmentTransactionsBinding
import com.example.newleaf2022.dataclasses.Accounts
import com.example.newleaf2022.dataclasses.Transactions
import com.example.newleaf2022.viewmodels.BudgetsViewModel

class TransactionsFragment(private val currentAccount: Accounts) : Fragment() {

    private var fragmentBinding: FragmentTransactionsBinding? = null
    private val binding get() = fragmentBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentBinding = FragmentTransactionsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val budgetsVM: BudgetsViewModel by activityViewModels()
        val mainActivity = (context as MainActivity)


        // Getting account's associated transactions
        var currentTransactions = currentAccount.transactions
        binding.fragTransactionsRecycler.adapter = TransactionAdapter(currentTransactions)



        binding.accountNameTV.text = currentAccount.name


    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentBinding = null
    }
}