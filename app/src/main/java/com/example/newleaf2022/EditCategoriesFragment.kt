package com.example.newleaf2022

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
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

        // Populating the recycler view
        var currentCategories = budgetsVM.getCurrentBudget().getCategories()
        if (currentCategories.isNullOrEmpty()) {
            currentCategories = arrayListOf()
        }




        

        binding.btnConfirmEdits.setOnClickListener {
            // Deleting categories & subcategories with empty names
            for ((i,item) in budgetsVM.getCurrentBudget().getCategories().withIndex()) {
                if (item.getName().equals(null) || item.getName().equals("")) {
                    budgetsVM.getCurrentBudget().removeCategory(i)
                }
                else {
                    for ((j,subcategory) in item.getSubcategories().withIndex()) {
                        if (subcategory.getName().equals(null) || subcategory.getName().equals("")) {
                            budgetsVM.getCurrentBudget().removeSubcategory(i,j)
                        }
                    }
                }
            }
            budgetsVM.updateModelBudget(mainActivity.model)
            mainActivity.changeFragment("main", BudgetFragment())
        }

        binding.btnAddCategory.setOnClickListener {
            budgetsVM.getCurrentBudget().addEmptyCategory()

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentBinding = null
    }


}