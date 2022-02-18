package com.example.newleaf2022

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newleaf2022.adapters.CategoryAdapter
import com.example.newleaf2022.databinding.FragmentBudgetsBinding
import com.example.newleaf2022.viewmodels.BudgetsViewModel
import com.example.newleaf2022.dataclasses.Categories
import com.example.newleaf2022.dataclasses.Subcategories

class BudgetsFragment : Fragment() {

    private var fragmentBinding: FragmentBudgetsBinding? = null
    private val binding get() = fragmentBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentBinding = FragmentBudgetsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainActivity = (context as MainActivity)
        val budgetsVM: BudgetsViewModel by activityViewModels()
        binding.fragBudgetsRecycler.layoutManager = LinearLayoutManager(activity)


        // Getting Budget data from ViewModel
        val currentBudget = budgetsVM.getCurrentBudget()

        val newAdapter = CategoryAdapter(currentBudget.categories, budgetsVM, mainActivity)
        binding.fragBudgetsRecycler.adapter = newAdapter

        newAdapter.setOnTextChangedListener(object: CategoryAdapter.OnTextChangedListener{
            override fun onTextChanged(position: Int) {

            }
        })




        // Populating RecyclerView

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