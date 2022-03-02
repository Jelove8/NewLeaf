package com.example.newleaf2022

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newleaf2022.adapters.CategoryAdapter
import com.example.newleaf2022.databinding.FragmentBudgetBinding
import com.example.newleaf2022.viewmodels.BudgetsViewModel

class BudgetFragment : Fragment() {

    private var fragmentBinding: FragmentBudgetBinding? = null
    private val binding get() = fragmentBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentBinding = FragmentBudgetBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fragBudgetsRecycler.layoutManager = LinearLayoutManager(activity)
        val mainActivity = (context as MainActivity)
        val budgetsVM: BudgetsViewModel by activityViewModels()

        // Displaying unassigned amount
        binding.outputTotalUnassigned.text = budgetsVM.getCurrentBudget().getUnassigned().toString()

        // Populating the recycler view
        var currentCategories = budgetsVM.getCurrentBudget().getCategories()
        if (currentCategories.isNullOrEmpty()) {
            currentCategories = arrayListOf()
        }
        val newAdapter = CategoryAdapter(currentCategories, budgetsVM, mainActivity.model, binding.outputTotalUnassigned)

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
        binding.btnEditBudget.setOnClickListener {
            mainActivity.changeFragment("main", EditCategoriesFragment())
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentBinding = null
    }

}