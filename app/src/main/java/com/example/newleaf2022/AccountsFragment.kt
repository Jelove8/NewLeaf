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
import com.example.newleaf2022.viewmodels.Accounts
import com.example.newleaf2022.viewmodels.AccountsViewModel

class AccountsFragment : Fragment() {

    private var fragmentBinding: FragmentAccountsBinding? = null
    private val binding get() = fragmentBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentBinding = FragmentAccountsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val accountsVM: AccountsViewModel by activityViewModels()
        binding.fragAccountsRecycler.layoutManager = LinearLayoutManager(activity)


        binding.fragAccountsRecycler.adapter = AccountsAdapter(accountsVM.accounts.value)

        binding.fragAccountsButton2.setOnClickListener {
            (context as MainActivity).changeFragment(NewAccountFragment())
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentBinding = null
    }

}