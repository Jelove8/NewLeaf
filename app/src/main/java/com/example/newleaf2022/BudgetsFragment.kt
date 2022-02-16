package com.example.newleaf2022

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newleaf2022.databinding.FragmentBudgetsBinding

class BudgetsFragment : Fragment() {

    private var fragmentBinding: FragmentBudgetsBinding? = null
    private val binding get() = fragmentBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentBinding = FragmentBudgetsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val budgetsVM : BudgetsViewModel by activityViewModels()
        binding.fragTreesRecycler.layoutManager = LinearLayoutManager(activity)



        binding.btnMisc1.setOnClickListener {

        }
        binding.btnChangeDate.setOnClickListener {

        }
        binding.btnEditBranches.setOnClickListener {


        }
        binding.btnAssignMoney.setOnClickListener {

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentBinding = null
    }

}