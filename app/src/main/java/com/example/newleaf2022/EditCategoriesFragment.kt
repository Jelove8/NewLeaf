package com.example.newleaf2022

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newleaf2022.adapters.EditCategoriesAdapter
import com.example.newleaf2022.databinding.FragmentEditCategoriesBinding
import com.example.newleaf2022.databinding.FragmentNewAccountBinding
import com.example.newleaf2022.viewmodels.BudgetsViewModel

class EditCategoriesFragment : Fragment() {

    private var fragmentBinding: FragmentEditCategoriesBinding? = null
    private val binding get() = fragmentBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentBinding = FragmentEditCategoriesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fragEditCategoriesRecycler.layoutManager = LinearLayoutManager(activity)
        val mainActivity = context as MainActivity
        val budgetsVM: BudgetsViewModel by activityViewModels()

        if (budgetsVM.getCurrentBudget().getCategories()[0].equals(null)) {
            binding.fragEditCategoriesRecycler.adapter = EditCategoriesAdapter(arrayListOf(), budgetsVM)
        }
        else {
            binding.fragEditCategoriesRecycler.adapter = EditCategoriesAdapter(budgetsVM.getCurrentBudget().getCategories(), budgetsVM)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentBinding = null
    }


}