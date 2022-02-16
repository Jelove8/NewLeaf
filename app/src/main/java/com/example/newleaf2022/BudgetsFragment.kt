package com.example.newleaf2022

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newleaf2022.databinding.FragmentBudgetsBinding
import com.example.newleaf2022.viewmodels.AccountsViewModel
import com.example.newleaf2022.viewmodels.TreesViewModel

class BudgetsFragment : Fragment() {

    private var fragmentBinding: FragmentBudgetsBinding? = null
    private val binding get() = fragmentBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentBinding = FragmentBudgetsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val treesVM: TreesViewModel by activityViewModels()
        binding.fragTreesRecycler.layoutManager = LinearLayoutManager(activity)

        val currentTree = treesVM.currentTreeDisplayed.value












    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentBinding = null
    }

}