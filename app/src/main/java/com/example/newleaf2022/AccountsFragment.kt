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
import com.example.newleaf2022.viewmodels.*

class AccountsFragment : Fragment() {

    private lateinit var binding: FragmentAccountsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAccountsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainActivity = (context as MainActivity)
        binding.fragAccountsRecycler.layoutManager = LinearLayoutManager(activity)

        val currentAccounts = mainActivity.getInstanceOfViewModel().getAllAccounts()

        binding.fragAccountsRecycler.adapter = AccountsAdapter(currentAccounts, mainActivity)

        binding.btnAddNewAccount.setOnClickListener {
            mainActivity.changeFragment("main", NewAccountFragment())
        }
    }
}