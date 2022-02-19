package com.example.newleaf2022

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.newleaf2022.databinding.FragmentTransactionsBinding
import com.example.newleaf2022.viewmodels.BudgetsViewModel

class TransactionsFragment : Fragment() {

    private var fragmentBinding: FragmentTransactionsBinding? = null
    private val binding get() = fragmentBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentBinding = FragmentTransactionsBinding.inflate(inflater,container,false)
        return binding.root
        val budgetsVM: BudgetsViewModel by activityViewModels()
        val mainActivity = (context as MainActivity)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentBinding = null
    }
}